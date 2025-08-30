import {useContext, useState} from "react";
import {assets} from "../../assets/assets.js";
import {AppContext} from "../../context/AppContext.jsx";
import {toast} from "react-hot-toast";
import {addItem} from "../../service/itemService.js";

const ItemForm = () => {
    const {categories, setItemsData, itemsData,setCategories} = useContext(AppContext);
    const [image, setImage] = useState(false);
    const [loading, setLoading] = useState(false);
    const [data, setData] = useState({
        name: "",
        categoryId: "",
        price: "",
        description: "",
    });

    const onChangeHandler = (e) => {
        const value=e.target.value;
        const name = e.target.name;
        setData((data) => ({...data, [name]: value}));


    }

    const onSubmitHandler = async(e) => {
        e.preventDefault();
        setLoading(true);
        const formData=new FormData();
        formData.append("item",JSON.stringify(data));
        formData.append("file",image);
        try{
            if(!image){
                toast.error("Select image");
                return;
            }
            const response =await addItem(formData);
            if(response.status === 201) {
                setItemsData([itemsData, response.data]);
                setCategories((prevCategories) =>
                    prevCategories.map((category)=> category.categoryId === data.categoryId ?{...category, items:category.items+1}:category)
                );
                toast.success("Item added ");
                setData({
                    name: "",
                    description: "",
                    price: "",
                    categoryId:"",
                })
                setImage(false);
            }else{
                toast.error("Unable to add item");
            }
        } catch(error){
            console.error(error);
            toast.error("Unable to add item");
        }finally {
            setLoading(false);
        }



    }

    return (
       <div className="item-form-container" style={{height:'100vh',overflowY:'hidden',overflowX:'hidden'}}>
           <div className="mx-2 mt-2">
               <div className="row">
                   <div className="card col-md-8 form-container">
                       <div className="card-body">
                           <form onSubmit={onSubmitHandler}>
                               <div className="mb-3">
                                   <label htmlFor="image" className="form-label">
                                       <img src={image ? URL.createObjectURL(image) : assets.upload} alt="" width={48}/>
                                   </label>
                                   <input type="file" className="form-control" id="image" name="image" hidden onChange={(e) => setImage(e.target.files[0])}/>
                               </div>
                               <div className="mb-3">
                                   <label htmlFor="name" className="form-label">Name</label>
                                   <input type="text"
                                          className="form-control"
                                          id="name"
                                          name="name"
                                          placeholder="Item Name"
                                          onChange={onChangeHandler}
                                          value={data.name}
                                          require
                                   />
                               </div>
                               <div className="mb-3">
                                   <label htmlFor="category" className="form-label">
                                       Category
                                   </label>
                                   <select className="form-control" id="category" name="categoryId" onChange={onChangeHandler} value={data.categoryId} required>
                                       <option value="">---SELECT CATEGORY---</option>
                                       {categories.map((category, index) => (
                                         <option key={index} value={category.categoryId}>{category.name}</option>
                                       ))}
                                   </select>
                               </div>
                               <div className="mb-3">
                                   <label htmlFor="price" className="form-label">Price</label>
                                   <input type="number"
                                          className="form-control"
                                          id="price"
                                          name="price"
                                          placeholder="&#8377;1000"
                                          onChange={onChangeHandler}
                                          value={data.price}
                                          required

                                   />

                               </div>
                               <div className="mb-3">
                                   <label htmlFor="description" className="form-label">Description</label>
                                   <textarea
                                       rows="5"
                                       className="form-control"
                                       id="description"
                                       name="description"
                                       placeholder="Write content here.."
                                   onChange={onChangeHandler}
                                   value={data.description}>

                                </textarea>
                               </div>
                               <button type="submit" className="btn btn-warning w-100" disabled={loading}>
                                   {loading ? "Loading..." : "Save"}
                               </button>
                           </form>
                       </div>

                   </div>
               </div>
           </div>
       </div>
    )
}
export default ItemForm;