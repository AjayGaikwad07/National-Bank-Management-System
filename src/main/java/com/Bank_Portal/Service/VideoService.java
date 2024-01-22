package com.ImageProject.Service;

import com.ImageProject.Entity.Video;
import com.ImageProject.Repository.VideoRepository;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.LifecycleState;
import org.apache.catalina.Server;
import org.apache.catalina.deploy.NamingResourcesImpl;
import org.apache.catalina.startup.Catalina;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.naming.Context;
import java.io.File;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    //    public void saveVideo(String title, MultipartFile file) throws IOException {
//        Video video = new Video();
//        video.setTitle(title);
//        video.setData(file.getBytes());
//        videoRepository.save(video);
//    }
    public void deleteVideo(@PathVariable Long id){
        videoRepository.deleteById(id);
    }

    public void saveVideo(Video video){
        videoRepository.save(video);

    }

    public void openConnection(){
        Server server = new Server() {
            @Override
            public NamingResourcesImpl getGlobalNamingResources() {
                return null;
            }

            @Override
            public void setGlobalNamingResources(NamingResourcesImpl namingResources) {

            }

            @Override
            public Context getGlobalNamingContext() {
                return null;
            }

            @Override
            public int getPort() {
                return 0;
            }

            @Override
            public void setPort(int i) {

            }

            @Override
            public int getPortOffset() {
                return 0;
            }

            @Override
            public void setPortOffset(int i) {

            }

            @Override
            public int getPortWithOffset() {
                return 0;
            }

            @Override
            public String getAddress() {
                return null;
            }

            @Override
            public void setAddress(String s) {

            }

            @Override
            public String getShutdown() {
                return null;
            }

            @Override
            public void setShutdown(String s) {

            }

            @Override
            public ClassLoader getParentClassLoader() {
                return null;
            }

            @Override
            public void setParentClassLoader(ClassLoader classLoader) {

            }

            @Override
            public Catalina getCatalina() {
                return null;
            }

            @Override
            public void setCatalina(Catalina catalina) {

            }

            @Override
            public File getCatalinaBase() {
                return null;
            }

            @Override
            public void setCatalinaBase(File file) {

            }

            @Override
            public File getCatalinaHome() {
                return null;
            }

            @Override
            public void setCatalinaHome(File file) {

            }

            @Override
            public int getUtilityThreads() {
                return 0;
            }

            @Override
            public void setUtilityThreads(int i) {

            }

            @Override
            public void addService(org.apache.catalina.Service service) {

            }

            @Override
            public void await() {

            }

            @Override
            public org.apache.catalina.Service findService(String s) {
                return null;
            }

            @Override
            public org.apache.catalina.Service[] findServices() {
                return new org.apache.catalina.Service[0];
            }

            @Override
            public void removeService(org.apache.catalina.Service service) {

            }

            @Override
            public Object getNamingToken() {
                return null;
            }

            @Override
            public ScheduledExecutorService getUtilityExecutor() {
                return null;
            }

            @Override
            public void addLifecycleListener(LifecycleListener lifecycleListener) {

            }

            @Override
            public LifecycleListener[] findLifecycleListeners() {
                return new LifecycleListener[0];
            }

            @Override
            public void removeLifecycleListener(LifecycleListener lifecycleListener) {

            }

            @Override
            public void init() throws LifecycleException {

            }

            @Override
            public void start() throws LifecycleException {

            }

            @Override
            public void stop() throws LifecycleException {

            }

            @Override
            public void destroy() throws LifecycleException {

            }

            @Override
            public LifecycleState getState() {
                return null;
            }

            @Override
            public String getStateName() {
                return null;
            }
        };
    }





}

