package com.example.backend.taskhandling.logic.api.mapper;

import com.example.backend.taskhandling.dataaccess.api.entity.TaskEntity;
import com.example.backend.taskhandling.logic.api.to.TaskEto;
import com.example.backend.taskhandling.logic.api.to.TaskTo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-10T20:52:09+0200",
    comments = "version: 1.4.0.Final, compiler: javac, environment: Java 14.0.2 (BellSoft)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public TaskEntity toTaskEntity(TaskTo taskTo) {
        if ( taskTo == null ) {
            return null;
        }

        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setName( taskTo.getName() );
        if ( taskTo.getFinalDate() != null ) {
            taskEntity.setFinalDate( LocalDate.parse( taskTo.getFinalDate() ) );
        }

        return taskEntity;
    }

    @Override
    public TaskEto toTaskEto(TaskEntity taskEntity) {
        if ( taskEntity == null ) {
            return null;
        }

        TaskEto taskEto = new TaskEto();

        if ( taskEntity.getFinalDate() != null ) {
            taskEto.setFinalDate( DateTimeFormatter.ofPattern( "yyyy-MM-dd" ).format( taskEntity.getFinalDate() ) );
        }
        taskEto.setId( taskEntity.getId() );
        taskEto.setName( taskEntity.getName() );

        return taskEto;
    }
}