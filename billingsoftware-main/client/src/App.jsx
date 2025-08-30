import Menubar from "./components/Menubar/Menubar.jsx";
import {Routes, Route, useLocation, Navigate} from "react-router-dom";
import ManageCategory from "./pages/ManageCategory/ManageCategory.jsx";
import ManageUsers from "./pages/ManageUsers/ManageUsers.jsx";
import ManageItem from "./pages/ManageItems/ManageItem.jsx";
import Explore from "./pages/Explore/Explore.jsx";
import Dashboard from "./pages/Dashboard/Dashboard.jsx";
import { Toaster } from "react-hot-toast";
import Login from "./pages/Login/Login.jsx";
import OrderHistory from "./pages/OrderHistory/OrderHistory.jsx";
import {useContext} from "react";
import {AppContext} from "./context/AppContext.jsx";
import NotFound from "./pages/NotFound/NotFound.jsx";

const App = () => {
  const location = useLocation();
  const{auth}=useContext(AppContext);

  const LoginRoute=({element}) =>{
      if(auth.token){
          return <Navigate to="/dashboard" replace/>
      }
      return element;
  }
  const ProtectedRoute=({element, allowedRoles})=>{
      if(!auth.token){
          return <Navigate to="/login" replace/>
      }
      if(allowedRoles && !allowedRoles.includes(auth.role)){
          return <Navigate to="/dashboard" replace/>
      }
      return element;
  }
  return (
    <div>
      {location.pathname !== "/login" && <Menubar />}
      <Toaster />
      <Routes>
        <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/explore" element={<Explore />} />
          {/*Admin only routes*/}
        <Route path="/category" element={<ProtectedRoute element={<ManageCategory />} allowedRoles={['ROLE_ADMIN']} />} />
        <Route path="/users" element={<ProtectedRoute element={<ManageUsers />} allowedRoles={['ROLE_ADMIN']} />} />
        <Route path="/items" element={<ProtectedRoute element={<ManageItem />} allowedRoles={['ROLE_ADMIN']} />} />

          <Route path="/login" element={<LoginRoute element={<Login/>}  />} />
          <Route path="/orders" element={<OrderHistory />} />
        <Route path="/" element={<Dashboard />} />
          <Route path="*" element={<NotFound />} />
      </Routes>
    </div>
  );
};
export default App;
