package kroryi.board.service;

import kroryi.board.dao.UserDAO;
import kroryi.board.dto.User;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAO();

    @Override
    public User select(String userid) {
        return userDAO.select(userid);
    }

    @Override
    public int insert(User user) {
        return userDAO.insert(user);
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int delete(User user) {
        return 0;
    }
}
