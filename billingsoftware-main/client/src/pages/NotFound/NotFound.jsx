import './NotFound.css';
import {useNavigate} from "react-router-dom";

const NotFound = () => {
   const navigate= useNavigate();
    return(
        <div className="not-fount-containe">
            <div className="not-found-content">
               <h1 className="not-found-title">404</h1>
               < h2 className="not-found-subtitle">Oops! Page not found</h2>
                <p className="not-found-message">
                    The page you are looking for doesn't exist or has been moved.
                </p>
                <button className="not-found-button" onClick={()=> navigate("/")}>
                    Go to homepage
                </button>
            </div>
        </div>
    )
}

export default NotFound;