package com.example.mergiterog.service;


import com.example.mergiterog.domain.Friendship;
import com.example.mergiterog.domain.User;
import com.example.mergiterog.domain.Validator.FriendshipValidator;
import com.example.mergiterog.domain.Validator.ValidationException;
import com.example.mergiterog.domain.Validator.Validator;
import com.example.mergiterog.repository.Repository;
import com.example.mergiterog.repository.dbrepo.FriendshipDbRepository;
import com.example.mergiterog.repository.dbrepo.UtilizatorDbRepository;

import java.util.List;

public class ServiceFriendship{

    FriendshipValidator friendshipValidator = new FriendshipValidator();
    FriendshipDbRepository FriendRepository = FriendshipDbRepository.getInstance();

    UtilizatorDbRepository UserRepository = UtilizatorDbRepository.getInstance();

    public static ServiceFriendship instance = null;
    public  ServiceFriendship(){};
    public static ServiceFriendship getInstance()
    {
        if(instance == null){
            instance = new ServiceFriendship();
        }
        return instance;
    }

    //prietenie noua       friendschip    1 , 2 , 3
    //prietenie veche      friendschip1   2 , 3 , 5
    public void addElem(Friendship friendship) {
        int ok1 = 0, ok2 = 0;
        for (Friendship friendship1 : FriendRepository.findAll()) {
            if (friendship1.getId() == friendship.getId()) {
                throw new ValidationException("Id-urile prieteniei introduse exista deja !");
            }
            if (friendship1.getIdUser1() == friendship.getIdUser1() && friendship1.getIdUser2() == friendship.getIdUser2()) {
                throw new ValidationException("Aceasta prietenie exista deja! ");
            }
            if (friendship1.getIdUser1() == friendship.getIdUser2() && friendship1.getIdUser2() == friendship.getIdUser1()) {
                throw new ValidationException("Aceasta prietenie exista deja! ");
            }
        }
        for (User user : UserRepository.findAll())
        {
            if (friendship.getIdUser1() == user.getId())
            {
                ok1 = 1;
            }
            if (friendship.getIdUser2() == user.getId()) {
                ok2 = 1;
            }
        }
        if(ok1!=1){throw new ValidationException("Nu exista userul 1 !");}
        if(ok2!=1){throw new ValidationException("Nu exista userul 2 !");}

        if (ok1 + ok2 == 2) {
            friendshipValidator.validate(friendship);
            FriendRepository.save(friendship);

        }
    }

    public Friendship getById(int id){
        for(Friendship friendship: FriendRepository.findAll()){
            if(friendship.getId() == id)
                return friendship;
        }
        throw new ValidationException("Nu exista astfel de prietenie cu id-ul dat");
    }

    public Integer getId(){
        Integer k=0;
        for(Friendship friendship : FriendRepository.findAll())
        {
            if(k<friendship.getId())
                k=friendship.getId();
        }
        return k;
    }

    public List<Friendship> getAllFriends(){return FriendRepository.findAll();}
}
