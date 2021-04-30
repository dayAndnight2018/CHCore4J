package com.chenghua.ios;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.zip.*;

public class ZipUtils {

    public static boolean writeZip(OutputStream out, ZipPackage zipPackage) throws IOException {
        if (zipPackage == null || zipPackage.size() == 0 || out == null) {
            return false;
        }

        try (
                CheckedOutputStream cos = new CheckedOutputStream(out, new Adler32());
                ZipOutputStream zos = new ZipOutputStream(cos);
                BufferedOutputStream bos = new BufferedOutputStream(zos);
        ) {

            for (Map.Entry<String, InputStream> entry : zipPackage.entries()) {
                try (
                        BufferedInputStream bis = new BufferedInputStream(entry.getValue());
                ) {
                    zos.putNextEntry(new ZipEntry(entry.getKey()));
                    int i = 0;
                    byte[] data = new byte[1024 * 1024 * 5];
                    while ((i = bis.read(data)) != -1) {
                        bos.write(data, 0, i);
                    }
                }
                bos.flush();
            }

        }
        return true;
    }

    public static boolean readZip(InputStream in, Path destDirectory) throws IOException {
        if(in == null || destDirectory == null || !Files.exists(destDirectory)|| !Files.isDirectory(destDirectory) ){
            return false;
        }
        try (
                CheckedInputStream cis = new CheckedInputStream(in, new Adler32());
                ZipInputStream zis = new ZipInputStream(cis);
                BufferedInputStream bis = new BufferedInputStream(zis);
        ) {
            ZipEntry ze = null;
            byte[] data = new byte[1024 * 1024 * 5];
            while ((ze = zis.getNextEntry())!=null){
                Path temp = Paths.get(destDirectory.toString(), ze.getName());
                try(
                        BufferedOutputStream bos = new BufferedOutputStream(FileUtils.openWriteStream(temp));
                ){
                    int i = 0;
                    while ((i = bis.read(data)) != -1) {
                        bos.write(data, 0, i);
                    }
                    bos.flush();
                }
            }
            return true;
        }
    }
}
