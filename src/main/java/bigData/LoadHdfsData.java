package com.chinadaas.factionIden;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;

import java.io.*;
import java.net.URI;

/**
 * @author xyf
 * @Data Created in 11:52 2018/6/27
 * @Descriptions
 */
public class LoadHdfsData {
    public static void main(String[] args) throws IOException {
        String hdfsSrc = "hdfs://192.168.100.101:/tmp/chinadaas_20180503/E_INV_INVESTMENT";
        String localDst = "E:\\E_INV_INVESTMENT";
        boolean b = downFromHdfsDir(hdfsSrc, localDst);
    }
    //下载单个文件
    public static boolean downloadFromHdfs(String hdfsSrc, String localDst) {
        Configuration conf = new Configuration();
        Path dst = new Path(hdfsSrc);
        try {
            Path Src = new Path(hdfsSrc);
            String Filename = Src.getName().toString();
            String local = localDst + Filename;
            Path Dst = new Path(local);
            FileSystem fs = FileSystem.get(URI.create(hdfsSrc), conf);
            FSDataInputStream in = fs.open(Src);
            OutputStream output = new FileOutputStream(new File(local));
            IOUtils.copyBytes(in, output, 4096, true);
            System.out.print(" download successed.");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.print(" download failed.");
            return false;
        }
        return true;

    }
    //下载目录下所有文件，方法1：  IOUtils.copyBytes或者copyToLocal
    public static boolean downFromHdfsDir(String hdfsSrc, String localDst)
            throws IOException {
        Configuration conf = new Configuration();
        Path dstpath = new Path(hdfsSrc);
        int i = 1;
        FileSystem fs = FileSystem.get(URI.create(hdfsSrc), conf);
        try {
            String subPath = "";
            FileStatus[] fList = fs.listStatus(dstpath);
            for (FileStatus f : fList) {
                if (null != f) {
                    subPath = new StringBuffer()
                            .append(f.getPath().getParent()).append("/")
                            .append(f.getPath().getName()).toString();
                    if (f.isDir()) {
                        downFromHdfsDir(subPath, localDst);
                    } else {
                        System.out.println("/t/t" + subPath);// hdfs://54.0.88.53:8020/
                        Path dst = new Path(subPath);
                        i++;
                        FSDataInputStream in = null;
                        OutputStream output = null;
                        try {
                            Path Src = new Path(subPath);
                            String Filename = Src.getName().toString();
                            String local = localDst + Filename;
                            Path Dst = new Path(local);
                            FileSystem hdfs = FileSystem.get(URI
                                    .create(subPath), conf);
                            in = hdfs.open(Src);
                            output = new FileOutputStream(new File(local));
                            // true-是否关闭数据流，如果是false则在finally里关闭
                            // IOUtils.copyBytes(in, output, 4096, false);
                            IOUtils.copyBytes(in, output, conf);
                            output.flush();
                            System.out.print(" download successed.");
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                            System.out.print(" download failed.");
                        } finally {
                            IOUtils.closeStream(in);
                            IOUtils.closeStream(output);
                        }
                    }
                }
            }
        } catch (Exception e) {
        } finally {
            System.out.println("the number of files is :" + i);
        }
        return true;
    }

    //下载目录下所有文件，方法2： 按字节复制
    public static boolean downFromHdfsDir2(String hdfsSrc, String localDst)
            throws IOException {
        Configuration conf = new Configuration();
        Path dstpath = new Path(hdfsSrc);
        int i = 1;
        FileSystem fs = FileSystem.get(URI.create(hdfsSrc), conf);
        try {
            String subPath = "";
            FileStatus[] fList = fs.listStatus(dstpath);
            for (FileStatus f : fList) {
                if (null != f) {
                    subPath = new StringBuffer()
                            .append(f.getPath().getParent()).append("/")
                            .append(f.getPath().getName()).toString();
                    if (f.isDir()) {
                        downFromHdfsDir(subPath, localDst);
                    } else {
                        System.out.println("/t/t" + subPath);// hdfs://54.0.88.53:8020/
                        Path dst = new Path(subPath);
                        i++;
                        try {
                            Path Src = new Path(subPath);
                            String Filename = Src.getName().toString();
                            String local = localDst + Filename;
                            Path Dst = new Path(local);
                            FileSystem localFS = FileSystem.getLocal(conf);
                            FileSystem hdfs = FileSystem.get(URI
                                    .create(subPath), conf);
                            FSDataInputStream in = hdfs.open(Src);
                            FSDataOutputStream output = localFS.create(Dst);
                            byte[] buf = new byte[1024];
                            int readbytes = 0;
                            while ((readbytes = in.read(buf)) > 0) {
                                output.write(buf, 0, readbytes);
                            }
                            in.close();
                            output.close();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                            System.out.print(" download failed.");
                        } finally {
                        }
                    }
                }
            }
        } catch (Exception e) {
        } finally {
            System.out.println("the number of files is :" + i);
        }
        return true;
    }

    //下载目录下所有文件，方法2： 按行复制
    public static boolean downFromHdfsDir3(String hdfsSrc, String localDst)
            throws IOException {
        Configuration conf = new Configuration();
        Path dstpath = new Path(hdfsSrc);
        int i = 1;
        FileSystem fs = FileSystem.get(URI.create(hdfsSrc), conf);
        try {
            String subPath = "";
            FileStatus[] fList = fs.listStatus(dstpath);
            for (FileStatus f : fList) {
                if (null != f) {
                    subPath = new StringBuffer()
                            .append(f.getPath().getParent()).append("/")
                            .append(f.getPath().getName()).toString();
                    if (f.isDir()) {
                        downFromHdfsDir(subPath, localDst);
                    } else {
                        System.out.println("/t/t" + subPath);// hdfs://54.0.88.53:8020/
                        Path dst = new Path(subPath);
                        i++;
                        try {
                            Path Src = new Path(subPath);
                            String Filename = Src.getName().toString();
                            String local = localDst + Filename;
                            Path Dst = new Path(local);
                            FileSystem localFS = FileSystem.getLocal(conf);
                            FileSystem hdfs = FileSystem.get(URI
                                    .create(subPath), conf);
                            FSDataInputStream in = hdfs.open(Src);
                            BufferedReader read = new BufferedReader(new InputStreamReader(in));
                            BufferedWriter output=new BufferedWriter(new FileWriter(local));
                            String line = null;
                            while ((line = read.readLine()) != null) {
                                output.append(line);
                                output.newLine();
                                output.flush();
                            }
                            in.close();
                            read.close();
                            output.close();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                            System.out.print(" download failed.");
                        } finally {
                        }
                    }
                }
            }
        } catch (Exception e) {
        } finally {
            System.out.println("the number of files is :" + i);
        }
        return true;
    }
}
