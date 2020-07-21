package com.chenghua.ios;
import com.chenghua.extendslite.StringExtends;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileUtils {


    /**
     * serialize object to stream
     * @param data
     * @param ops
     * @return
     * @throws IOException
     */
    public static boolean serializeToStream(Object data, OutputStream ops) throws IOException {
        if(data == null){
            return false;
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(ops)) {
            oos.writeObject(data);
            return true;
        }
    }

    /**
     * serialize object to file
     * @param data
     * @param path
     * @return
     * @throws IOException
     */
    public static boolean serializeToFile(Object data, Path path) throws IOException {
        if (!exist(path) || Files.isDirectory(path)) {
            return false;
        }
        try (OutputStream ops = openWriteStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(ops)) {
            oos.writeObject(data);
            return true;
        }
    }

    /**
     * serialize object to file
     * @param data
     * @param path
     * @return
     * @throws IOException
     */
    public static boolean serializeToFile(Object data, String path) throws IOException {
        if (StringExtends.isBlank(path))
            return false;
        Path p = Paths.get(path);

        return  serializeToFile(data,p);
    }

    /**
     * deserialize object  from stream
     * @param ins
     * @param <T>
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static <T> T deserializeFromStream(InputStream ins) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(ins)) {
            return (T) ois.readObject();
        }
    }

    /**
     * deserialize object  from file
     * @param path
     * @param <T>
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static <T> T  deserializeFromFile(Path path) throws IOException, ClassNotFoundException {
        if (!exist(path) || Files.isDirectory(path)) {
            return null;
        }
        try (InputStream ins = openReadStream(path);
             ObjectInputStream ois = new ObjectInputStream(ins)) {
            return (T) ois.readObject();
        }
    }

    /**
     * deserialize object  from file
     * @param path
     * @param <T>
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static <T> T  deserializeFromFile(String path) throws IOException, ClassNotFoundException {
        if (StringExtends.isBlank(path))
            return null;
        Path p = Paths.get(path);

        return  deserializeFromFile(p);
    }

    /**
     * random read
     * @param path
     * @return
     */
    public static SeekableByteChannel openReadByteBuffer(Path path) {
        if (!exist(path) || Files.isDirectory(path)) {
            return null;
        }
        try {
            SeekableByteChannel sbc = Files.newByteChannel(path, StandardOpenOption.READ);
            return sbc;
        } catch (IOException exception) {
            return null;
        }
    }

    /**
     * random read
     * @param path
     * @return
     */
    public static SeekableByteChannel openReadByteBuffer(String path) {
        if (StringExtends.isBlank(path))
            return null;
        Path p = Paths.get(path);
        return openReadByteBuffer(p);
    }

    /**
     * random write
     * @param path
     * @return
     */
    public static SeekableByteChannel openWriteByteBuffer(Path path) {
        if (exist(path) && Files.isDirectory(path)) {
            return null;
        }
        try {
            SeekableByteChannel sbc = Files.newByteChannel(path, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
            return sbc;
        } catch (IOException exception) {
            return null;
        }
    }

    /**
     * random write
     * @param path
     * @return
     */
    public static SeekableByteChannel openWriteByteBuffer(String path) {
        if (StringExtends.isBlank(path))
            return null;
        Path p = Paths.get(path);
        return openWriteByteBuffer(p);
    }

    /**
     * random write
     * @param path
     * @param append
     * @return
     */
    public static SeekableByteChannel openWriteByteBuffer(Path path, boolean append) {
        if (exist(path) && Files.isDirectory(path)) {
            return null;
        }
        if (!append)
            return openWriteByteBuffer(path);
        try {
            SeekableByteChannel sbc = Files.newByteChannel(path, StandardOpenOption.WRITE, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
            return sbc;
        } catch (IOException exception) {
            return null;
        }
    }

    /**
     * random write
     * @param path
     * @param append
     * @return
     */
    public static SeekableByteChannel openWriteByteBuffer(String path, boolean append) {
        if (StringExtends.isBlank(path))
            return null;
        Path p = Paths.get(path);
        return openWriteByteBuffer(p, append);
    }

    /**
     * open character reader
     * @param path
     * @param charset
     * @return
     */
    public static BufferedReader openReader(Path path, Charset charset) {
        if (!exist(path) || Files.isDirectory(path)) {
            return null;
        }
        if (charset == null) {
            charset = StandardCharsets.UTF_8;
        }
        try {
            BufferedReader bfw = Files.newBufferedReader(path, charset);
            return bfw;
        } catch (IOException exception) {
            return null;
        }
    }

    /**
     * open character reader
     * @param path
     * @param charset
     * @return
     */
    public static BufferedReader openReader(String path, Charset charset) {
        if (StringExtends.isBlank(path))
            return null;
        Path p = Paths.get(path);
        return openReader(p, charset);
    }

    /**
     * open character writer
     * @param path
     * @return
     */
    public static BufferedWriter openWriter(Path path) {
        if (!exist(path) || Files.isDirectory(path)) {
            return null;
        }

        try {
            BufferedWriter bfw = Files.newBufferedWriter(path, StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            return bfw;
        } catch (IOException exception) {
            return null;
        }
    }

    /**
     * open character writer
     * @param path
     * @param append
     * @return
     */
    public static BufferedWriter openWriter(Path path, boolean append) {
        if (!exist(path) || Files.isDirectory(path)) {
            return null;
        }
        if (!append)
            return openWriter(path);
        try {
            BufferedWriter bfw = Files.newBufferedWriter(path, StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            return bfw;
        } catch (IOException exception) {
            return null;
        }
    }

    /**
     * open character writer
     * @param path
     * @return
     */
    public static BufferedWriter openWriter(String path) {
        if (StringExtends.isBlank(path))
            return null;
        Path p = Paths.get(path);
        return openWriter(p);
    }

    /**
     * open character writer
     * @param path
     * @param append
     * @return
     */
    public static BufferedWriter openWriter(String path, boolean append) {
        if (StringExtends.isBlank(path))
            return null;
        Path p = Paths.get(path);
        return openWriter(p, append);
    }

    /**
     * open byte read stream
     * @param path
     * @return
     */
    public static InputStream openReadStream(Path path) {
        if (!exist(path) || Files.isDirectory(path)) {
            return null;
        }

        try {
            InputStream ins = Files.newInputStream(path, StandardOpenOption.READ);
            return ins;
        } catch (IOException exception) {
            return null;
        }
    }

    /**
     *  open byte read stream
     * @param path
     * @return
     */
    public static InputStream openReadStream(String path) {
        if (StringExtends.isBlank(path))
            return null;
        Path p = Paths.get(path);
        return openReadStream(p);
    }

    /**
     *  open byte write stream
     * @param path
     * @return
     */
    public static OutputStream openWriteStream(Path path) {
        if (exist(path) && Files.isDirectory(path)) {
            return null;
        }

        try {
            OutputStream ops = Files.newOutputStream(path, StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            return ops;
        } catch (IOException exception) {
            return null;
        }
    }

    /**
     * open byte write stream
     * @param path
     * @return
     */
    public static OutputStream openWriteStream(String path) {
        if (StringExtends.isBlank(path))
            return null;
        Path p = Paths.get(path);
        return openWriteStream(p);
    }

    /**
     * open byte write stream
     * @param path
     * @param append
     * @return
     */
    public static OutputStream openWriteStream(Path path, boolean append) {
        if (exist(path) && Files.isDirectory(path)) {
            return null;
        }
        if (!append)
            return openWriteStream(path);
        try {
            OutputStream ops = Files.newOutputStream(path, StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            return ops;
        } catch (IOException exception) {
            return null;
        }
    }

    /**
     * open byte write stream
     * @param path
     * @param append
     * @return
     */
    public static OutputStream openWriteStream(String path, boolean append) {
        if (StringExtends.isBlank(path))
            return null;
        Path p = Paths.get(path);
        return openWriteStream(p, append);
    }

    /**
     * write text to path with charset sync (for small size of file)
     *
     * @param path
     * @param text
     * @param charset
     * @return
     */
    public static boolean writeAllText(Path path, List<String> text, Charset charset) {
        if (exist(path) && Files.isDirectory(path)) {
            return false;
        }
        if (charset == null) {
            charset = StandardCharsets.UTF_8;
        }
        try {
            Files.write(path, text, charset, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.SYNC);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    /**
     * write text to path with charset async  (for small size of file)
     *
     * @param path
     * @param text
     * @param charset
     * @return
     */
    public static boolean writeAllTextAsync(Path path, List<String> text, Charset charset) {
        if (exist(path) && Files.isDirectory(path)) {
            return false;
        }
        if (charset == null) {
            charset = StandardCharsets.UTF_8;
        }
        try {
            Files.write(path, text, charset, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    /**
     * append text to path sync (for small size of file)
     *
     * @param path
     * @param text
     * @param charset
     * @param append
     * @return
     */
    public static boolean writeAllText(Path path, List<String> text, Charset charset, boolean append) {
        if (exist(path) && Files.isDirectory(path)) {
            return false;
        }
        if (charset == null) {
            charset = StandardCharsets.UTF_8;
        }
        if (!append)
            return writeAllText(path, text, charset);
        try {
            Files.write(path, text, charset, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND, StandardOpenOption.SYNC);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    /**
     * append text to path async (for small size of file)
     *
     * @param path
     * @param text
     * @param charset
     * @param append
     * @return
     */
    public static boolean writeAllTextAsync(Path path, List<String> text, Charset charset, boolean append) {
        if (exist(path) && Files.isDirectory(path)) {
            return false;
        }
        if (charset == null) {
            charset = StandardCharsets.UTF_8;
        }
        if (!append)
            return writeAllText(path, text, charset);
        try {
            Files.write(path, text, charset, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    /**
     * write bytes to path sync (for small size of file)
     *
     * @param path
     * @param bytes
     * @return
     */
    public static boolean writeAllBytes(Path path, byte[] bytes) {
        if (exist(path) && Files.isDirectory(path)) {
            return false;
        }

        try {
            Files.write(path, bytes, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.SYNC);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    /**
     * write bytes to path async (for small size of file)
     *
     * @param path
     * @param bytes
     * @return
     */
    public static boolean writeAllBytesAsync(Path path, byte[] bytes) {
        if (exist(path) && Files.isDirectory(path)) {
            return false;
        }

        try {
            Files.write(path, bytes, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    /**
     * append bytes to path sync (for small size of file)
     *
     * @param path
     * @param bytes
     * @return
     */
    public static boolean writeAllBytes(Path path, byte[] bytes, boolean append) {
        if (exist(path) && Files.isDirectory(path)) {
            return false;
        }
        if (!append)
            return writeAllBytes(path, bytes);
        try {
            Files.write(path, bytes, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND, StandardOpenOption.SYNC);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    /**
     * append bytes to path async (for small size of file)
     *
     * @param path
     * @param bytes
     * @return
     */
    public static boolean writeAllBytesAsync(Path path, byte[] bytes, boolean append) {
        if (exist(path) && Files.isDirectory(path)) {
            return false;
        }
        if (!append)
            return writeAllBytes(path, bytes);
        try {
            Files.write(path, bytes, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    /**
     * write text to path sync (for small size of file)
     *
     * @param path
     * @param text
     * @param charset
     * @return
     */
    public static boolean writeAllText(String path, List<String> text, Charset charset) {
        if (StringExtends.isBlank(path))
            return false;
        Path p = Paths.get(path);
        if (exist(p) && Files.isDirectory(p)) {
            return false;
        }
        if (charset == null) {
            charset = StandardCharsets.UTF_8;
        }
        try {
            Files.write(p, text, charset, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.SYNC);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    /**
     * write text to path async (for small size of file)
     *
     * @param path
     * @param text
     * @param charset
     * @return
     */
    public static boolean writeAllTextAsync(String path, List<String> text, Charset charset) {
        if (StringExtends.isBlank(path))
            return false;
        Path p = Paths.get(path);
        if (exist(p) && Files.isDirectory(p)) {
            return false;
        }
        if (charset == null) {
            charset = StandardCharsets.UTF_8;
        }
        try {
            Files.write(p, text, charset, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    /**
     * append text to path sync (for small size of file)
     *
     * @param path
     * @param text
     * @param charset
     * @param append
     * @return
     */
    public static boolean writeAllText(String path, List<String> text, Charset charset, boolean append) {
        if (StringExtends.isBlank(path))
            return false;
        Path p = Paths.get(path);
        if (exist(p) && Files.isDirectory(p)) {
            return false;
        }
        if (charset == null) {
            charset = StandardCharsets.UTF_8;
        }
        if (!append)
            return writeAllText(p, text, charset);
        try {
            Files.write(p, text, charset, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND, StandardOpenOption.SYNC);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    /**
     * append text to path async (for small size of file)
     *
     * @param path
     * @param text
     * @param charset
     * @param append
     * @return
     */
    public static boolean writeAllTextAsync(String path, List<String> text, Charset charset, boolean append) {
        if (StringExtends.isBlank(path))
            return false;
        Path p = Paths.get(path);
        if (exist(p) && Files.isDirectory(p)) {
            return false;
        }
        if (charset == null) {
            charset = StandardCharsets.UTF_8;
        }
        if (!append)
            return writeAllText(p, text, charset);
        try {
            Files.write(p, text, charset, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    /**
     * write bytes to path sync (for small size of file)
     *
     * @param path
     * @param bytes
     * @return
     */
    public static boolean writeAllBytes(String path, byte[] bytes) {
        if (StringExtends.isBlank(path))
            return false;
        Path p = Paths.get(path);
        if (exist(path) && Files.isDirectory(p)) {
            return false;
        }

        try {
            Files.write(p, bytes, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.SYNC);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    /**
     * write bytes to path sync (for small size of file)
     *
     * @param path
     * @param bytes
     * @return
     */
    public static boolean writeAllBytesAsync(String path, byte[] bytes) {
        if (StringExtends.isBlank(path))
            return false;
        Path p = Paths.get(path);
        if (exist(path) && Files.isDirectory(p)) {
            return false;
        }

        try {
            Files.write(p, bytes, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    /**
     * append bytes to path sync (for small size of file)
     *
     * @param path
     * @param bytes
     * @param append
     * @return
     */
    public static boolean writeAllBytes(String path, byte[] bytes, boolean append) {
        if (StringExtends.isBlank(path))
            return false;
        Path p = Paths.get(path);
        if (exist(p) && Files.isDirectory(p)) {
            return false;
        }
        if (!append)
            return writeAllBytes(p, bytes);
        try {
            Files.write(p, bytes, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND, StandardOpenOption.SYNC);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    /**
     * append bytes to path async (for small size of file)
     *
     * @param path
     * @param bytes
     * @param append
     * @return
     */
    public static boolean writeAllBytesAsync(String path, byte[] bytes, boolean append) {
        if (StringExtends.isBlank(path))
            return false;
        Path p = Paths.get(path);
        if (exist(p) && Files.isDirectory(p)) {
            return false;
        }
        if (!append)
            return writeAllBytes(p, bytes);
        try {
            Files.write(p, bytes, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    /**
     * read text from path width charset (for small size of file)
     *
     * @param path
     * @param charset
     * @return
     */
    public static List<String> readAllText(Path path, Charset charset) {
        if (!exist(path) || Files.isDirectory(path)) {
            return null;
        }
        if (charset == null) {
            charset = StandardCharsets.UTF_8;
        }
        try {
            return Files.readAllLines(path, charset);
        } catch (IOException exception) {
            return null;
        }
    }

    /**
     * read text from path width charset (for small size of file)
     *
     * @param path
     * @param charset
     * @return
     */
    public static List<String> readAllText(String path, Charset charset) {
        if (StringExtends.isBlank(path))
            return null;
        Path p = Paths.get(path);
        if (!exist(p) || Files.isDirectory(p)) {
            return null;
        }
        return readAllText(p, charset);
    }

    /**
     * read bytes from path width charset (for small size of file)
     *
     * @param path
     * @return
     */
    public static byte[] readAllBytes(Path path) {
        if (!exist(path) || Files.isDirectory(path)) {
            return null;
        }
        try {
            return Files.readAllBytes(path);
        } catch (IOException exception) {
            return null;
        }
    }

    /**
     * read bytes from path width charset (for small size of file)
     *
     * @param path
     * @return
     */
    public static byte[] readAllBytes(String path) {
        if (StringExtends.isBlank(path))
            return null;
        Path p = Paths.get(path);
        if (!exist(p) || Files.isDirectory(p)) {
            return null;
        }
        return readAllBytes(p);
    }


    public static boolean move(Path source, Path target) {
        if (!exist(source) || exist(target)) {
            return false;
        }
        try {
            Files.move(source, target, StandardCopyOption.COPY_ATTRIBUTES);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    public static boolean move(Path source, Path target, boolean override) {
        if (!exist(source) || exist(target)) {
            return false;
        }
        if (!override) {
            return move(source, target);
        }
        try {
            Files.move(source, target, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    public static boolean move(String source, String target) {
        if (StringExtends.isBlank(source) || StringExtends.isBlank(target)) {
            return false;
        }
        Path sourcePath = Paths.get(source);
        Path targetPath = Paths.get(target);
        if (!exist(sourcePath) || exist(targetPath)) {
            return false;
        }
        try {
            Files.move(sourcePath, targetPath, StandardCopyOption.COPY_ATTRIBUTES);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    public static boolean move(String source, String target, boolean override) {
        if (StringExtends.isBlank(source) || StringExtends.isBlank(target)) {
            return false;
        }
        Path sourcePath = Paths.get(source);
        Path targetPath = Paths.get(target);
        if (!exist(sourcePath)) {
            return false;
        }
        if (!override) {
            return move(sourcePath, targetPath);
        }
        try {
            Files.move(sourcePath, targetPath, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    public static boolean copy(Path source, Path target) {
        if (!exist(source) || !exist(target)) {
            return false;
        }
        try {
            Files.copy(source, target, StandardCopyOption.COPY_ATTRIBUTES);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    public static boolean copy(Path source, Path target, boolean override) {
        if (!exist(source) || !exist(target)) {
            return false;
        }
        if (!override) {
            return copy(source, target);
        }
        try {
            Files.copy(source, target, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    public static boolean copy(String source, String target) {
        if (StringExtends.isBlank(source) || StringExtends.isBlank(target)) {
            return false;
        }
        Path sourcePath = Paths.get(source);
        Path targetPath = Paths.get(target);
        if (!exist(sourcePath) || !exist(targetPath)) {
            return false;
        }
        try {
            Files.copy(sourcePath, targetPath, StandardCopyOption.COPY_ATTRIBUTES);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    /**
     * 复制
     *
     * @param source
     * @param target
     * @param override
     * @return
     */
    public static boolean copy(String source, String target, boolean override) {
        if (StringExtends.isBlank(source) || StringExtends.isBlank(target)) {
            return false;
        }
        Path sourcePath = Paths.get(source);
        Path targetPath = Paths.get(target);
        if (!exist(sourcePath) || !exist(targetPath)) {
            return false;
        }
        if (!override) {
            return copy(sourcePath, targetPath);
        }
        try {
            Files.copy(sourcePath, targetPath, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    /**
     * 获取子目录
     *
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
     *
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
     *
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
     *
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
