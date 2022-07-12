package com.cg.hrms.employee.service;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import com.cg.hrms.employee.model.DbSequence;



@Service
public class SequenceGeneratorService {

    private MongoOperations mongoOperations;
    public int getSequenceNumber(String sequenceName) {
        //get sequence no
        Query query = new Query(Criteria.where("id").is(sequenceName));
        //update the sequence no
        Update update = new Update().inc("seq",500);
        //modify in document
        //login id will start from 500
        DbSequence counter = mongoOperations
                .findAndModify(query,
                        update, options().returnNew(true).upsert(true),
                        DbSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() :1;
    }
	public static String generateSequence(String sequenceName) {
		// TODO Auto-generated method stub
		return null;
	}
}