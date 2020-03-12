package com.example.daily1.model.repo;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * for every data we have to create resource a
 * then we create a class of common method between resources
 * every time Data change 'pack or itemOfPack' then we have to initial Generic class
 */
public interface DataSource<T,E> { //T for type of resource (object) and T for type of id then both are Generic

    //this method get id and return resource
    //out data is list then single
    Single<T> get(E id);

    //out is delete done or not and don't parameter as return output
    Completable delete(T item);

    //list all of data
    Single<List<T>> getAll(int page);

    //after insert,return object as output
    Single<T> insert(T item);

    Single<T> update(T item);

}
