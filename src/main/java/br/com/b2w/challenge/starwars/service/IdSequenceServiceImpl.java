package br.com.b2w.challenge.starwars.service;

import br.com.b2w.challenge.starwars.model.db.IdSequence;
import br.com.b2w.challenge.starwars.service.interfaces.IdSequenceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/*
* Code based in the tutorial
* available at https://www.baeldung.com/spring-boot-mongodb-auto-generated-field
* */

@Service
public class IdSequenceServiceImpl implements IdSequenceServiceInterface {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public long getIdAndUpdate(String sequenceName) {
        IdSequence counter =
                mongoOperations.findAndModify(
                        query(where("_id").is(sequenceName)),
                        new Update().inc("seq",1),
                        options().returnNew(true).upsert(true),
                        IdSequence.class
                );

        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }
}
