package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

class OwnerSDJpaServiceTest {
    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    Owner savedOwner;
    private final String LAST_NAME = "Thompson";

    @BeforeEach
    void setUp() {
        savedOwner = new Owner();
        savedOwner.setId(1L);
        savedOwner.setLastName(LAST_NAME);
    }

    @Test
    void findByLastname() {
        when(ownerRepository.findByLastName(any())).thenReturn(savedOwner);

        Owner owner = ownerSDJpaService.findByLastname("Thompson");

        assertEquals(owner.getLastName(), savedOwner.getLastName());
        assertEquals("Thompson", owner.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        Owner owner1 = new Owner();
        Owner owner2 = new Owner();
        ownerSet.add(owner1);
        ownerSet.add(owner2);

        when(ownerRepository.findAll()).thenReturn(ownerSet);

        Set<Owner> retuendOwners = ownerSDJpaService.findAll();

        assertNotNull(retuendOwners);
        assertEquals(2, retuendOwners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(savedOwner));

        Owner returnedOwner = ownerSDJpaService.findById(1L);
        assertNotNull(returnedOwner);
        //assertEquals(1L, returnedOwner.getId());
    }

    @Test
    void save() {
        Owner ownerToSave = new Owner();
        ownerToSave.setId(1L);

        when(ownerRepository.save(any())).thenReturn(ownerToSave);

        Owner owner = ownerSDJpaService.save(ownerToSave);

        assertEquals(owner.getId(), ownerToSave.getId());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(savedOwner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }
}