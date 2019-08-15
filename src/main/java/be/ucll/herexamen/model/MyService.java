package be.ucll.herexamen.model;

import be.ucll.herexamen.repositry.JobRepository;
import be.ucll.herexamen.repositry.UserRepository;
import be.ucll.herexamen.repositry.WerkgeverRepository;
import be.ucll.herexamen.repositry.WerknemerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.text.ParseException;
import java.util.List;

@org.springframework.stereotype.Service
public class MyService {


    @Autowired
    JobRepository jobsRepository;

    @Autowired
    WerknemerRepository werknemerRepository;

    @Autowired
    WerkgeverRepository werkgeverRepository;

    @Autowired
    UserRepository userRepository;






    public MyService() {

    }
    // JOB
    //tested
    public Job findJobById(int id){
        return jobsRepository.findById(id);
    }

    //tested
    public Job addJob(Job job, Werkgever currentUser) {
        job.setWerkgever(currentUser);
        return jobsRepository.save(job);
    }
    //tested
    public Job addJob(Job job) {
        return jobsRepository.save(job);
    }

    //tesed
    public List<Job> getAllJobs() {
        return jobsRepository.findAll();
    }

    //tested
    public List <Job> getAllBeschikbareJobs(){
        return jobsRepository.findByJobStatus("Beschikbaar");
    }

    //tesed
    public List <Job> findAllJobsOfWG(Werkgever wg){
        return jobsRepository.findAllByWerkgeverId( wg.getId());
    }
    // WG

//tested
    public List<Werkgever> findAllWerkgevers(){
        return werkgeverRepository.findAll();
    }
//tested
    public Werkgever findWerkgeverByEmail(String email) {
        return werkgeverRepository.findByEmail(email);
    }

    public void addWerkgever(Werkgever werkgever) {

        Werkgever werkgever1 = werkgeverRepository.findByEmail(werkgever.getEmail());
        if ( werkgever1 == null){
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            String ww = werkgever.getPassword();
            String encodedWW = encoder.encode(ww);
            werkgever.setPassword(encodedWW);
            werkgeverRepository.save(werkgever);
        }
    }



    public void updateJob(int id, Job changedJob) {
        Job j = findJobById(id);
        j.updateJob(changedJob);
        jobsRepository.save(j);
    }

    public void updateJobZonderId(Job job){
        jobsRepository.save(job);
    }

//tested
    public void deleteJobById(int id) {
        Job j = findJobById(id);
        jobsRepository.delete(j);
    }

    public List<Job> getJobWithBeschrijving(String beschrijving){

        List<Job> jl = jobsRepository.findByJobStatusAndBeschrijvingLike("Beschikbaar","%"+ beschrijving + "%");
        return jl;
    }
    // WN
    //tested
    public List<Werknemer> findAllWerknemers(){
        return werknemerRepository.findAll();
    }


    private Werknemer findWerknemerByEmail(String email) {
        return werknemerRepository.findByEmail(email);
    }

    public void addWerknemer(Werknemer werknemer) {
        Werknemer werknemer1 = werknemerRepository.findByEmail(werknemer.getEmail());
        if ( werknemer1 == null){
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            String ww = werknemer.getPassword();
            String encodedWW = encoder.encode(ww);
            werknemer.setPassword(encodedWW);
            werknemerRepository.save(werknemer);
        }
    }

    public void addJobToWN(String wnEmail, int id) throws Exception {
        Werknemer wn = werknemerRepository.findByEmail(wnEmail);

        Job j = jobsRepository.findById(id);
        j.setJobStatus("Volzet");
        jobsRepository.save(j);
        wn.addNewCurrentJob(j);
        werknemerRepository.save(wn);
    }

    public String findRoleWerknemerByMail(String wnEmail){
        Werknemer wn = werknemerRepository.findByEmail(wnEmail);
        String role = wn.getRole();
        return role;
    }

    public Werknemer findWerknemerByMail(String mail){
        return werknemerRepository.findByEmail(mail);
    }

    public Job getCurrentJobOfWerknemer(Werknemer nm) {
        return nm.getCurrentJob();
    }

     public List<Job> getAllJobsWN(Werknemer wn){
        return wn.getJobs();
     }
    //USER

    public List<User> getAllUsers(){
       return  userRepository.findAll();
    }
    public String findRoleUserByMail(String mail) {
        User user = userRepository.findByEmail(mail);
        return user.getRole();
    }

    public User findUserByMail(String mail) {
        return  userRepository.findByEmail(mail);
    }


    public void updateJobScoreAndResetCurrentJob(int id, int scoreJob, User user) {
        Werknemer wg = (Werknemer) user;
        wg.setCurrentJob(null);
        werknemerRepository.save(wg);
        Job j = jobsRepository.findById(id);
        j.setJobStatus("Voltooid");
        j.setScore(scoreJob);
        jobsRepository.save(j);
        berekenScoreWerkgever(j.getWerkgever().getEmail());
    }

    private void berekenScoreWerkgever(String email) {
        Werkgever wg = werkgeverRepository.findByEmail(email);
        List<Job> jobs = jobsRepository.findAllByWerkgeverId(wg.getId());
        int totaalscore = 0;
        for (Job j : jobs){
            totaalscore += j.getScore();
        }
        totaalscore /= jobs.size();

        wg.setScore(totaalscore);

        werkgeverRepository.save(wg);
    }


    public void updateWerkgever(Werkgever werkgever) {
        Werkgever wg = findWerkgeverByEmail(werkgever.getEmail());

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String ww = werkgever.getPassword();
        String encodedWW = encoder.encode(ww);
        werkgever.setPassword(encodedWW);

        wg.updateWg(werkgever);

        werkgeverRepository.save(wg);
    }

    public void updateWerknemer(Werknemer werknemer) throws ParseException {
        Werknemer wn = findWerknemerByEmail(werknemer.getEmail());

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String ww = werknemer.getPassword();
        String encodedWW = encoder.encode(ww);
        werknemer.setPassword(encodedWW);

        wn.updateWn(werknemer);

        werknemerRepository.save(wn);
    }


    public void deleteWerknemerById(int id) {
            Werknemer wn = werknemerRepository.findById(id);
            Job j = wn.getCurrentJob();
            if ( j != null){
                j.setJobStatus("Beschikbaar");
                jobsRepository.save(j);
            }

            werknemerRepository.delete(wn);
    }

    public void deleteWerkgeverById(int id) {
        Werkgever wg = werkgeverRepository.findById(id);
        List<Job> jobs = jobsRepository.findAllByWerkgeverId(id);
        if (!jobs.isEmpty()){
            for (Job j : jobs){
                jobsRepository.delete(j);
            }
        }
        werkgeverRepository.delete(wg);
    }
}
