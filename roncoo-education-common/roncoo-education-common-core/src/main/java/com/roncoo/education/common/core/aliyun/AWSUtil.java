package com.roncoo.education.common.core.aliyun;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.File;

public class AWSUtil {
    private static final String awsAccessKeyId = "AKIA4BWGFBQFONUGY4VO";
    private static final String awsAccessKeySecret = "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";
    private static final Region region = Region.US_WEST_1;
    private static final String S3Endpoint = "s3.us-west-1.amazonaws.com";

    public static S3Client getS3Client() {
        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(
                awsAccessKeyId, awsAccessKeySecret);
        S3Client s3 = S3Client.builder().region(region)
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .build();

        return s3;
    }

    public static String uploadPic(String prefix, File file, S3Client s3){
        String name = file.getName();
//        String filePath = prefix + "/" + "random_uuid" + name.substring(name.lastIndexOf("."));
        String filePath = (prefix + "/" + name);

//      createBucket(s3, bucketName, region);
        String bucketName = "bucket1654575383716";
        PutObjectRequest objectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(filePath)
                .build();

        s3.putObject(objectRequest, RequestBody.fromFile(file));
        String url = "https://" + bucketName + "." + S3Endpoint +"/" + filePath;
        return url;
    }
    public static String uploadDoc(String prefix, File file, S3Client s3){
        String name = file.getName();
        String filePath = (prefix + "/" + name);

//      createBucket(s3, bucketName, region);
        String bucketName = "bucket1654575383716";
        PutObjectRequest objectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(filePath)
                .build();
        s3.putObject(objectRequest, RequestBody.fromFile(file));
        String url = "https://" + bucketName + "." + S3Endpoint +"/" + filePath;
        return url;
    }


}
