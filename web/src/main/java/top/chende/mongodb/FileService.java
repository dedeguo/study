package top.chende.mongodb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    public void saveFile(MultipartFile file){
//        FileDocument fileDocument;

    }

}
