package kodlama.io.Kodlama.io.Devs.core.utilities.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
	ModelMapper forRequest();
	ModelMapper forResponse();
}
