package kroryi.board.service;

import kroryi.board.dto.User;

public interface UserService {

    User select(String userid);

    int insert(User user);

    int update(User user);

    int delete(User user);
}
