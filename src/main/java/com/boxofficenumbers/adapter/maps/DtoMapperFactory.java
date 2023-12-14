package com.boxofficenumbers.adapter.maps;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Component;

@Component
public class DtoMapperFactory {
    private MapperFactory mapperFactoryInstance;

            public DtoMapperFactory() {
                mapperFactoryInstance = new DefaultMapperFactory.Builder().build();
                constructClassMaps(mapperFactoryInstance);
            }

            public MapperFacade getMapper() { return mapperFactoryInstance.getMapperFacade();}

    protected void constructClassMaps(MapperFactory mapperFactory) {
                mapperFactory.classMap()
    }
}
