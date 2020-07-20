package com.chenghua.ios;
import com.chenghua.extendslite.StringExtends;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileUtils {

    public static boolean writeAllText(Path path, List<String> text, Charset charset){
        if(exist(path) && Files.isDirectory(path)){
            return false;
        }
        if(charset == null){
            charset = StandardCharsets.UTF_8;
        }
        try{
            Files.write(path,text,charset,StandardOpenOption.CREATE,StandardOpenOption.WRITE,StandardOpenOption.TRUNCATE_EXISTING);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    public static boolean writeAllText(Path path, List<String> text, Charset charset,boolean append){
        if(exist(path) && Files.isDirectory(path)){
            return false;
        }
        if(charset == null){
            charset = StandardCharsets.UTF_8;
        }
        if(!append)
            return writeAllText(path,text,charset);
        try{
            Files.write(path,text,charset,StandardOpenOption.CREATE,StandardOpenOption.WRITE,StandardOpenOption.APPEND);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }


    public static boolean writeAllBytes(Path path, byte[] bytes){
        if(exist(path) && Files.isDirectory(path)){
            return false;
        }

        try{
            Files.write(path,bytes,StandardOpenOption.CREATE,StandardOpenOption.WRITE,StandardOpenOption.TRUNCATE_EXISTING);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    public static boolean writeAllBytes(Path path, byte[] bytes, boolean append){
        if(exist(path) && Files.isDirectory(path)){
            return false;
        }
        if(!append)
            return writeAllBytes(path,bytes);
        try{
            Files.write(path,bytes,StandardOpenOption.CREATE,StandardOpenOption.WRITE,StandardOpenOption.APPEND);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    public static boolean writeAllText(String path, List<String> text, Charset charset){
        if(StringExtends.isBlank(path))
            return false;
        Path p = Paths.get(path);
        if(exist(p) && Files.isDirectory(p)){
            return false;
        }
        if(charset == null){
            charset = StandardCharsets.UTF_8;
        }
        try{
            Files.write(p,text,charset,StandardOpenOption.CREATE,StandardOpenOption.WRITE,StandardOpenOption.TRUNCATE_EXISTING);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    public static boolean writeAllText(String path, List<String> text, Charset charset,boolean append){
        if(StringExtends.isBlank(path))
            return false;
        Path p = Paths.get(path);
        if(exist(p) && Files.isDirectory(p)){
            return false;
        }
        if(charset == null){
            charset = StandardCharsets.UTF_8;
        }
        if(!append)
            return writeAllText(p,text,charset);
        try{
            Files.write(p,text,charset,StandardOpenOption.CREATE,StandardOpenOption.WRITE,StandardOpenOption.APPEND);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }


    public static boolean writeAllBytes(String path, byte[] bytes){
        if(StringExtends.isBlank(path))
            return false;
        Path p = Paths.get(path);
        if(exist(path) && Files.isDirectory(p)){
            return false;
        }

        try{
            Files.write(p,bytes,StandardOpenOption.CREATE,StandardOpenOption.WRITE,StandardOpenOption.TRUNCATE_EXISTING);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    public static boolean writeAllBytes(String path, byte[] bytes, boolean append){
        if(StringExtends.isBlank(path))
            return false;
        Path p = Paths.get(path);
        if(exist(p) && Files.isDirectory(p)){
            return false;
        }
        if(!append)
            return writeAllBytes(p,bytes);
        try{
            Files.write(p,bytes,StandardOpenOption.CREATE,StandardOpenOption.WRITE,StandardOpenOption.APPEND);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }


    public static List<String> readAllText(Path path, Charset charset){
        if(!exist(path) || Files.isDirectory(path)){
            return null;
        }
        if(charset == null){
            charset = StandardCharsets.UTF_8;
        }
        try{
            return Files.readAllLines(path,charset);
        } catch (IOException exception) {
            return null;
        }
    }

    public static List<String> readAllText(String path, Charset charset){
        if(StringExtends.isBlank(path))
            return null;
        Path p = Paths.get(path);
        if(!exist(p) || Files.isDirectory(p)){
            return null;
        }
        return readAllText(p,charset);
    }

    public static byte[] readAllBytes(Path path){
        if(!exist(path) || Files.isDirectory(path)){
            return null;
        }
        try{
            return Files.readAllBytes(path);
        } catch (IOException exception) {
            return null;
        }
    }

    public static byte[] readAllBytes(String path){
        if(StringExtends.isBlank(path))
            return null;
        Path p = Paths.get(path);
        if(!exist(p) || Files.isDirectory(p)){
            return null;
        }
        return readAllBytes(p);
    }


    public static boolean move(Path source, Path target){
        if(!exist(source) || exist(target)){
            return false;
        }
        try {
            Files.move(source,target, StandardCopyOption.COPY_ATTRIBUTES);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    public static boolean move(Path source, Path target, boolean override){
        if(!exist(source) || exist(target)){
            return false;
        }
        if(!override){
            return move(source,target);
        }
        try {
            Files.move(source,target, StandardCopyOption.COPY_ATTRIBUTES,StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    public static boolean move(String source, String target){
        if(StringExtends.isBlank(source) || StringExtends.isBlank(target)){
            return false;
        }
        Path sourcePath = Paths.get(source);
        Path targetPath = Paths.get(target);
        if(!exist(sourcePath) || exist(targetPath)){
            return false;
        }
        try {
            Files.move(sourcePath,targetPath, StandardCopyOption.COPY_ATTRIBUTES);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    public static boolean move(String source, String target, boolean override){
        if(StringExtends.isBlank(source) || StringExtends.isBlank(target)){
            return false;
        }
        Path sourcePath = Paths.get(source);
        Path targetPath = Paths.get(target);
        if(!exist(sourcePath)){
            return false;
        }
        if(!override){
            return move(sourcePath,targetPath);
        }
        try {
            Files.move(sourcePath,targetPath, StandardCopyOption.COPY_ATTRIBUTES,StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    public static  boolean copy(Path source, Path target){
        if(!exist(source) || !exist(target)){
            return false;
        }
        try {
            Files.copy(source,target, StandardCopyOption.COPY_ATTRIBUTES);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    public  static boolean copy(Path source, Path target, boolean override){
        if(!exist(source) || !exist(target)){
            return false;
        }
        if(!override){
            return copy(source,target);
        }
        try {
            Files.copy(source,target, StandardCopyOption.COPY_ATTRIBUTES,StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    public static  boolean copy(String source, String target){
        if(StringExtends.isBlank(source) || StringExtends.isBlank(target)){
            return false;
        }
        Path sourcePath = Paths.get(source);
        Path targetPath = Paths.get(target);
        if(!exist(sourcePath) || !exist(targetPath)){
            return false;
        }
        try {
            Files.copy(sourcePath,targetPath, StandardCopyOption.COPY_ATTRIBUTES);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    /**
     * 复制
     * @param source
     * @param target
     * @param override
     * @return
     */
    public  static boolean copy(String source, String target, boolean override){
        if(StringExtends.isBlank(source) || StringExtends.isBlank(target)){
            return false;
        }
        Path sourcePath = Paths.get(source);
        Path targetPath = Paths.get(target);
        if(!exist(sourcePath) || !exist(targetPath)){
            return false;
        }
        if(!override){
            return copy(sourcePath,targetPath);
        }
        try {
            Files.copy(sourcePath,targetPath, StandardCopyOption.COPY_ATTRIBUTES,StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    /**
     * 获取子目录
     * @param path
     * @return
     */
    public static String[] getFiles(Path path) {
        if (!exist(path)) {
            return null;
        }

        try {
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
            List<String> pathList = new ArrayList<>();
            Iterator<Path> iterator = directoryStream.iterator();
            if (!iterator.hasNext()) {
                return null;
            }
            while (iterator.hasNext()) {
                pathList.add(iterator.next().toString());
            }
            return pathList.toArray(new String[pathList.size()]);
        } catch (IOException exception) {
            return null;
        }
    }

    /**
     * 获取子目录
     * @param path
     * @return
     */
    public static String[] getFiles(String path) {
        if (StringExtends.isBlank(path)) {
            return null;
        }

        Path p = Paths.get(path);
        return getFiles(p);
    }

    /**
     * 获取子目录
     * @param path
     * @return
     */
    public static Path[] getFilesPath(Path path) {
        if (!exist(path)) {
            return null;
        }

        try {
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
            List<Path> pathList = new ArrayList<>();
            Iterator<Path> iterator = directoryStream.iterator();
            if (!iterator.hasNext()) {
                return null;
            }
            while (iterator.hasNext()) {
                pathList.add(iterator.next());
            }
            return (Path[]) pathList.toArray();
        } catch (IOException exception) {
            return null;
        }
    }

    /**
     * 获取子目录
     * @param path
     * @return
     */
    public static Path[] getFilesPath(String path) {
        if (StringExtends.isBlank(path)) {
            return null;
        }

        Path p = Paths.get(path);
        return getFilesPath(p);
    }

    /**
     * get string file name
     *
     * @param path
     * @return
     */
    public static String getFileName(String path) {
        if (StringExtends.isBlank(path)) {
            return StringExtends.EMPTY;
        }
        Path p = Paths.get(path);
        if (!exist(p)) {
            return StringExtends.EMPTY;
        }
        return p.getFileName().toString();
    }

    /**
     * get path parent path
     *
     * @param path
     * @return
     */
    public static Path getParentPath(String path) {
        if (StringExtends.isBlank(path)) {
            return null;
        }
        Path p = Paths.get(path);
        if (!exist(p)) {
            return null;
        }
        return p.getParent();
    }

    /**
     * get string parent path
     *
     * @param path
     * @return
     */
    public static String getParent(String path) {
        if (StringExtends.isBlank(path)) {
            return null;
        }
        Path p = Paths.get(path);
        if (!exist(p)) {
            return null;
        }
        return p.getParent().toString();
    }

    /**
     * get path root path
     *
     * @param path
     * @return
     */
    public static Path getRootPath(String path) {
        if (StringExtends.isBlank(path)) {
            return null;
        }
        Path p = Paths.get(path);
        if (!exist(p)) {
            return null;
        }
        return p.getRoot();
    }

    /**
     * get string root path
     *
     * @param path
     * @return
     */
    public static String getRoot(String path) {
        if (StringExtends.isBlank(path)) {
            return null;
        }
        Path p = Paths.get(path);
        if (!exist(p)) {
            return null;
        }
        return p.getRoot().toString();
    }


    /**
     * judge file or directory exists
     *
     * @param path
     * @return
     */
    public static boolean exist(Path path) {
        if (path == null || !Files.exists(path)) {
            return false;
        }
        return true;
    }

    public static boolean exist(String path) {
        if (StringExtends.isBlank(path)) {
            return false;
        }
        Path p = Paths.get(path);
        return exist(p);
    }

    /**
     * create file or directory
     *
     * @param path
     * @return
     */
    public static boolean create(Path path) {
        if (path == null)
            return false;
        if (!exist(path)) {
            if (Files.isDirectory(path)) {
                try {
                    Files.createDirectory(path);
                    return true;
                } catch (IOException ex) {
                    return false;
                }

            } else {
                try {
                    Files.createFile(path);
                    return true;
                } catch (IOException ex) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * create file or directory
     *
     * @param path
     * @return
     */
    public static boolean create(String path) {
        if (StringExtends.isBlank(path))
            return false;
        Path p = Paths.get(path);
        if (!exist(p)) {
            if (Files.isDirectory(p)) {
                try {
                    Files.createDirectory(p);
                    return true;
                } catch (IOException ex) {
                    return false;
                }

            } else {
                try {
                    Files.createFile(p);
                    return true;
                } catch (IOException ex) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * delete file or directory
     *
     * @param path
     * @return
     */
    public static boolean delete(Path path) {
        if (!exist(path)) {
            return true;
        }
        if (Files.isDirectory(path)) {
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
                if (directoryStream.iterator().hasNext()) {
                    return false;
                }
                Files.delete(path);
                return true;
            } catch (IOException e) {
                return false;
            }
        } else {
            try {
                Files.delete(path);
                return true;
            } catch (Exception ex) {
                return false;
            }
        }
    }


    /**
     * delete file or directory
     *
     * @param path
     * @return
     */
    public static boolean delete(String path) {
        if (StringExtends.isBlank(path)) {
            return true;
        }
        Path p = Paths.get(path);
        if (!exist(p)) {
            return true;
        }
        if (Files.isDirectory(p)) {
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(p)) {
                if (directoryStream.iterator().hasNext()) {
                    return false;
                }
                Files.delete(p);
                return true;
            } catch (IOException e) {
                return false;
            }
        } else {
            try {
                Files.delete(p);
                return true;
            } catch (Exception ex) {
                return false;
            }
        }
    }
}
