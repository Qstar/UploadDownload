package com.imooc.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class FileDownloadAction extends ActionSupport {
    public String inputPath;
    public String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getInputPath() {
        return inputPath;
    }

    public void setInputPath(String inputPath) {
        this.inputPath = inputPath;
    }

    @Override
    public String execute() throws Exception {

        return SUCCESS;
    }

    public InputStream getInputStream() throws IOException {
        String path = ServletActionContext.getServletContext().getRealPath("/images");
        String filepath = path + "/" + filename;
        File file = new File(filepath);
        return FileUtils.openInputStream(file);
//        return ServletActionContext.getServletContext().getResourceAsStream(inputPath);
    }

    public String getDownloadFileName() throws UnsupportedEncodingException {
        String downloadFileName;
        downloadFileName = URLEncoder.encode("文件下载.jpg", "UTF-8");
        return downloadFileName;
    }
}
