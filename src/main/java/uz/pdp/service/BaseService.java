package uz.pdp.service;

import java.util.UUID;

public interface BaseService<T,Res> {
     Res add(T t);
     void remove(UUID id);
     Res getById(UUID id);




}
