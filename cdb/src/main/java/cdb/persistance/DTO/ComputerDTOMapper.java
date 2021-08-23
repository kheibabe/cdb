package cdb.persistance.DTO;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import cdb.model.Computer;

@Mapper(componentModel = "spring")

public interface ComputerDTOMapper {
	
	    void updateComputerFromDto(ComputerDTODb computerDTODb, @MappingTarget Computer entity);
	
}