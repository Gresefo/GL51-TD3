package test.gl51.movie.service.impl

import gl51.movie.service.impl.MovieRegistryImpl
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class MovieRegistryImplTest extends Specification
{
    @Inject
    MovieRegistryImpl registry

    // Test l'injection fait juste au dessus
    void "injection should work"()
    {
        expect:
            registry != null
    }

    // Verifie si listFavorites a bien été instencié à vide comme dans fait
    // dans l'implementation
    void "favorites should be empty"()
    {
        expect:
            registry.listFavorites() == []
    }

    // On test que si on appel la fonction addMovieToFavorites, alors
    // la taille de listFavorites va passer a un car un élément aura été rajouté
    void "adding a favourite should fill in the database"()
    {
        when:
            registry.addMovieToFavorites("testAddMovie")
        then:
            registry.listFavorites().size() == 1
    }
}
