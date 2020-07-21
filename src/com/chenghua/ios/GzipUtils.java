package com.chenghua.ios;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipUtils {

    public static boolean writeGzip(Path source, Path dest) throws IOException {
        if(!FileUtils.exist(source) || Files.isDirectory(source) || Files.isDirectory(dest)){
            return false;
        }
        try (InputStream ins = FileUtils.openReadStream(source);
             OutputStream ops = FileUtils.openWriteStream(dest);
                ){
            return writeGzip(ins,ops);
        }
    }

    public static boolean readGzip(Path source, Path dest) throws IOException {
        if(!FileUtils.exist(source) || Files.isDirectory(source) || Files.isDirectory(dest)){
            return false;
        }
        try (InputStream ins = FileUtils.openReadStream(source);
             OutputStream ops = FileUtils.openWriteStream(dest);
        ){
            return readGzip(ins,ops);
        }
    }

    public static boolean writeGzip(String source, String dest) throws IOException {
        if(!FileUtils.exist(source))
            return  false;
        Path sourcePath = Paths.get(source);
        Path destPath = Paths.get(dest);
        if(Files.isDirectory(sourcePath) || Files.isDirectory(destPath)){
            return false;
        }
        try (InputStream ins = FileUtils.openReadStream(sourcePath);
             OutputStream ops = FileUtils.openWriteStream(destPath);
        ){
            return writeGzip(ins,ops);
        }
    }

    public static boolean readGzip(String source, String dest) throws IOException {
        if(!FileUtils.exist(source))
            return  false;
        Path sourcePath = Paths.get(source);
        Path destPath = Paths.get(dest);
        if(Files.isDirectory(sourcePath) || Files.isDirectory(destPath)){
            return false;
        }
        try (InputStream ins = FileUtils.openReadStream(sourcePath);
             OutputStream ops = FileUtils.openWriteStream(destPath);
        ){
            return readGzip(ins,ops);
        }
    }

    public static boolean writeGzip(InputStream in, OutputStream out) throws IOException {
        try (
                BufferedInputStream bis = new BufferedInputStream(in);
                BufferedOutputStream bos = new BufferedOutputStream(new GZIPOutputStream(out));
        ) {
            int i = 0;
            byte[] data = new byte[1024 * 1024 * 5];
            while ((i = bis.read(data)) != -1) {
                bos.write(data,0,i);
            }
            return true;
        }
    }

    public static  boolean readGzip(InputStream in, OutputStream out) throws IOException {
        try (
                BufferedInputStream bis = new BufferedInputStream(new GZIPInputStream(in));
                BufferedOutputStream bos = new BufferedOutputStream(out);
        ) {
            int i = 0;
            byte[] data = new byte[1024 * 1024 * 5];
            while ((i = bis.read(data)) != -1) {
                bos.write(data,0,i);
            }
            return true;
        }
    }
}
