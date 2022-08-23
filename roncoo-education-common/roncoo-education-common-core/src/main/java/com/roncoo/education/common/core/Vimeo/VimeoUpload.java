package com.roncoo.education.common.core.Vimeo;
import java.io.File;
import com.clickntap.vimeo.*;
import cn.hutool.json.JSONUtil;
import com.roncoo.education.common.core.polyv.UploadFileResult;
import com.roncoo.education.common.core.tools.JSUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartFile;
@Component
public class VimeoUpload {

    public UploadFileResult uploadVimeo(String filename, File file){
        Vimeo vimeo = new Vimeo("7abf747fa89596c0940a2b37217fed5c");


        try{
        String videoEndPoint = vimeo.addVideo(file);


        //get video info
        VimeoResponse info = vimeo.getVideoInfo(videoEndPoint);
        JSONObject videoInfo = info.getJson();
        String duration = videoInfo.get("duration").toString();
        String id = videoEndPoint.split("/")[2];
        System.out.println((id));

        String name = filename;
        String desc = "";
        String license = "cc0"; //see Vimeo API Documentation
        String privacyView = "anybody"; //see Vimeo API Documentation
        String privacyEmbed = "whitelist"; //see Vimeo API Documentation
        boolean reviewLink = false;
        vimeo.updateVideoMetadata(videoEndPoint, name, desc, license, privacyView, privacyEmbed, reviewLink);
        UploadFileResult result = new UploadFileResult();
        result.setDuration(duration);
        result.setVid(id);
        return result;}
        catch(Exception e){
            e.printStackTrace(System.out);
            System.out.println("上传到vimeo失败");
            return null;
        }

    }
}
