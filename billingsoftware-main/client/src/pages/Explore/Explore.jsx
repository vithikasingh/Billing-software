import "./Explore.css";
import { useContext, useState } from "react";
import { AppContext } from "../../context/AppContext.jsx";
import DisplayCategory from "../../components/DisplayCategory/DisplayCategory.jsx";
import DisplayItems from "../../components/DisplayItems/DisplayItems.jsx";
import CustomerForm from "../../components/CustomerForm/CustomerForm.jsx";
import CartItems from "../../components/CartItems/CartItems.jsx";
import CartSummary from "../../components/CartSummary/CartSummary.jsx";

const Explore = () => {
  const { categories } = useContext(AppContext);
  const [selectedCategory, setSelectedCategory] = useState("");
  const [customerName, setCustomerName] = useState("");
  const [mobileNumber, setMobileNumber] = useState("");
  return (
    <div className="explore-container text-light">
      <div className="left-column">
        <div className="first-row" style={{ overflowY: "auto" }}>
          <DisplayCategory
            selectedCategory={selectedCategory}
            setSelectedCategory={setSelectedCategory}
            categories={categories}
          />
        </div>
        <hr className="horizontal-line" />
        <div className="second-row" style={{ overflowY: "auto" }}>
          <DisplayItems selectedCategory={selectedCategory} />
        </div>
      </div>
      <div className="right-column d-flex flex-column">
        <div className="customer-form-container" >
          <CustomerForm
            customerName={customerName}
            setCustomerName={setCustomerName}
            mobileNumber={mobileNumber}
            setMobileNumber={setMobileNumber}
          />
        </div>
        <hr className="my-3 text-light" />
        <div
          className="cart-items-container"
          style={{  overflowY: "auto" }}
        >
          <CartItems />
        </div>
        <div className="cart-summary-container" style={{ height: "30%" }}>
          <CartSummary
            customerName={customerName}
            setCustomerName={setCustomerName}
            mobileNumber={mobileNumber}
            setMobileNumber={setMobileNumber}
          />
        </div>
      </div>
    </div>
  );
};
export default Explore;
