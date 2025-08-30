import "./DisplayCategory.css";
import Category from "../Category/Category.jsx";
import { assets } from "../../assets/assets.js";

const DisplayCategory = ({
  selectedCategory,
  setSelectedCategory,
  categories,
}) => {
  return (

      <div className="row p-3" style={{ width: "100%", margin: 0 }}>
          <div key="all" className="col-md-3 col-sm-6" style={{ padding: "0 10px" }}>
        <Category
          categoryName="All Items"
          imgUrl={assets.device}
          numberOfItems={categories.reduce(
            (acc, category) => acc + category.items,
            0
          )}
          bgColor="#6c757d"
          isSelected={selectedCategory === ""}
          onClick={() => setSelectedCategory("")}
        />
      </div>

      {categories.map((category) => (
        <div
          key={category.categoryId}
          className="col-md-3 col-sm-6"
          style={{ padding: "0 10px" }}
        >
          <Category
            categoryName={category.name}
            imgUrl={category.imgUrl}
            numberOfItems={category.items}
            bgColor={category.bgColor}
            isSelected={selectedCategory === category.categoryId}
            onClick={() => setSelectedCategory(category.categoryId)}
          />
        </div>
      ))}
    </div>
  );
};

export default DisplayCategory;
