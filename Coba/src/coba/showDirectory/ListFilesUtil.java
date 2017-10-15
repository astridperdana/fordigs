/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coba.showDirectory;

/**
 *
 * @author 5213100176
 */
import java.io.File;

public class ListFilesUtil {
    /**
     * List all the files and folders from a directory
     * @param directoryName to be listed
     */
    public void listFilesAndFolders(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        String[] namefile;
        
        for (File file : fList){
            if (file.isFile()) {
                System.out.println(file.getName());   
            } else if (file.isDirectory()) {
                System.out.println(file.getName()); 
            }
        }
    }
    /**
     * List all the files under a directory
     * @param directoryName to be listed
     */
    public void listFiles(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isFile()){
                System.out.println(file.getName());
            }
        }
    }
    /**
     * List all the folder under a directory
     * @param directoryName to be listed
     */
    public void listFolders(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isDirectory()){
                System.out.println(file.getName());
            }
        }
    }
    /**
     * List all files from a directory and its subdirectories
     * @param directoryName to be listed
     */
    String a = "";
    public void listFilesAndFilesSubDirectories(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isFile()){
                a += file.getAbsolutePath() + "\n";
            } else if (file.isDirectory()){
                listFilesAndFilesSubDirectories(file.getAbsolutePath());
            }
        }
    }
    public static void main (String[] args){
        ListFilesUtil listFilesUtil = new ListFilesUtil();
        final String directoryLinuxMac ="/Users/loiane/test";
        //Windows directory example
        final String directoryWindows ="C:\\Users\\5213100176\\Downloads";
        //listFilesUtil.listFiles(directoryWindows);
        //listFilesUtil.listFilesAndFolders(directoryWindows);
        
        ListFilesUtil d = new ListFilesUtil();
        d.listFilesAndFilesSubDirectories(directoryWindows);
        System.out.println(d.a);
    }
}
