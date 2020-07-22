package br.com.b2w.challenge.starwars.service.interfaces;

public interface IdSequenceServiceInterface {
    long getIdAndUpdate(String sequenceName);
}
