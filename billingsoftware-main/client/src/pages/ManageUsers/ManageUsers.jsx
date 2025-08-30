import "./ManageUsers.css";
import UserForm from "../../components/UserForm/UserForm.jsx";
import UserList from "../../components/UsersList/UserList.jsx";
import { useEffect, useState } from "react";
import { toast } from "react-hot-toast";
import { fetchUsers } from "../../service/Userservice.js";

const ManageUsers = () => {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    async function loadUsers() {
      try {
        setLoading(true);
        const response = await fetchUsers();
        setUsers(response.data);
      } catch (error) {
        console.error(error);
        toast.error("Unable to fetch users");
      } finally {
        setLoading(false);
      }
    }
    loadUsers();
  }, []);

  return (
    <div className="users-container text-light">
      <div className="left-column">
        <UserForm setUsers={setUsers} />
      </div>
      <div className="right-column">
        <UserList users={users} setUsers={setUsers} />
      </div>
    </div>
  );
};
export default ManageUsers;
