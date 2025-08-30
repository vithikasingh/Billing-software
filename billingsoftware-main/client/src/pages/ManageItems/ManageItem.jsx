import './ManageItem.css'
import ItemForm from "../../components/itemForm/ItemForm.jsx";
import ItemList from "../../components/ItemList/ItemList.jsx";
const ManageItem = () => {
    return (
        <div className="items-container text-light">
            <div className="left-column">
                <ItemForm />
            </div>
            <div className="right-column">
                <ItemList />
            </div>
        </div>
    )
}
export default ManageItem;