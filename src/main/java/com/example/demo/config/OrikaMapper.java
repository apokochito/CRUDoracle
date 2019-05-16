package com.example.demo.config;

import com.example.demo.domain.ProductDomain;
import com.example.demo.entity.ProductEntity;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

public class OrikaMapper extends ConfigurableMapper {

    public MapperFactory mapper(MapperFactory factory){
        factory.classMap(ProductEntity.class, ProductDomain.class).byDefault().register();
        return factory;
    }
}
