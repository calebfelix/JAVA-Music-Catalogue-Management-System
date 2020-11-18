/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musiccataloguemasy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author caleb
 */
public class GetInfo {
    
    MySQLConnect myc = new MySQLConnect();
        
   
    
    
    int getTrackid(String pathh){
    int trackid=0 ;
    try {
        
        Connection con = myc.getConn();
        PreparedStatement pst ;
        String sql = "select * from tracks where audio=?";
        pst = con.prepareStatement(sql);
        pst.setString(1, pathh);
        ResultSet rs=pst.executeQuery();       
        while(rs.next()){
             trackid = rs.getInt("track_id");
            }       
        } catch (Exception e) {
            System.out.println("couldnt get track id");
        }
    return trackid;
}
    
    
    String getUserId(String path){
        String Userid="";
        try {
          
        
        Connection con = myc.getConn();
        PreparedStatement pst ;
        String sql = "select * from tracks where track_id=?";
        pst = con.prepareStatement(sql);
        int trackid= getTrackid(path);
        pst.setInt(1, trackid);
        ResultSet rs=pst.executeQuery();       
        while(rs.next()){
             Userid = rs.getString("user_id");
        }
        } catch (Exception e) {
            System.out.println("couldnt get user id");
        }
        return Userid ;
        
    }
    
    
        String getTrackName(String path){
        String Trackname="";
        try {
          
        
        Connection con = myc.getConn();
        PreparedStatement pst ;
        String sql = "select * from tracks where track_id=?";
        pst = con.prepareStatement(sql);
        int trackid= getTrackid(path);
        pst.setInt(1, trackid);
        ResultSet rs=pst.executeQuery();       
        while(rs.next()){
              Trackname = rs.getString("track_name");
        }

        } catch (Exception e) {
            System.out.println("couldnt get track name ");
        }
        return Trackname ;
        
    }
        
        String getTrackArtist(String path){
        String TrackArtist="";
        try {
          
        
        Connection con = myc.getConn();
        PreparedStatement pst ;
        String sql = "select * from tracks where track_id=?";
        pst = con.prepareStatement(sql);
        int trackid= getTrackid(path);
        pst.setInt(1, trackid);
        ResultSet rs=pst.executeQuery();       
            while (rs.next()) {                

              TrackArtist = rs.getString("artist");
            }

        } catch (Exception e) {
            System.out.println("couldnt get artist");
        }
        return TrackArtist ;
        
    }
        
        
        String getTrackGenre(String path){
        String TrackGenre="";
        try {
          
        
        Connection con = myc.getConn();
        PreparedStatement pst ;
        String sql = "select * from tracks where track_id=?";
        pst = con.prepareStatement(sql);
        int trackid= getTrackid(path);
        pst.setInt(1, trackid);
        ResultSet rs=pst.executeQuery();       
        while(rs.next()){
              TrackGenre = rs.getString("genre");
        }

        } catch (Exception e) {
            System.out.println("couldnt get genre");
        }
        return TrackGenre ;
        
    }    
        
        
        String getTrackDescription(String path){
        String TrackDescription="";
        try {
          
        
        Connection con = myc.getConn();
        PreparedStatement pst ;
        String sql = "select * from tracks where track_id=?";
        pst = con.prepareStatement(sql);
        int trackid= getTrackid(path);
        pst.setInt(1, trackid);
        ResultSet rs=pst.executeQuery();       
        while(rs.next()){
              TrackDescription = rs.getString("description");
        }
        } catch (Exception e) {
            System.out.println("couldnt get descr");
        }
        return TrackDescription ;
        
    }
        
        
        String getTrackAudio_p(String path){
        String TrackAudio_p="";
        try {
          
        
        Connection con = myc.getConn();
        PreparedStatement pst ;
        String sql = "select * from tracks where track_id=?";
        pst = con.prepareStatement(sql);
        int trackid= getTrackid(path);
        pst.setInt(1, trackid);
        ResultSet rs=pst.executeQuery();       
        while(rs.next()){
              TrackAudio_p = rs.getString("audio");
        }
        } catch (Exception e) {
            System.out.println("couldnt get audio_p");
        }
        return TrackAudio_p ;
        
    }
    
}
