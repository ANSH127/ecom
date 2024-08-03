import { useParams } from "react-router-dom";
import StarIcon from "@mui/icons-material/Star";
import StarBorderOutlinedIcon from "@mui/icons-material/StarBorderOutlined";
import { useEffect,useState } from "react";
export default function ProductDetailPage() {
  const { id } = useParams();
  //   console.log(id);

  const [productDetails, setProductDetails] = useState({});

  const fetchProductDetails = async () => {
    try {
      const response = await fetch(
        `http://localhost:8080/api/product/getproduct/${id}`
      );
      const data = await response.json();
      console.log(data);
      setProductDetails(data);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    fetchProductDetails();
  }, []);

  return (
    <div className="sm:w-4/5 w-full mx-auto text-black ">
      {/* // display product details here half  side image and half side details */}
      <div className="flex flex-wrap justify-around gap-x-2 py-4">
        <div className="sm:w-2/5 w-full mx-auto flex justify-center">
          <img
            src={productDetails.image}
            alt="product"
            style={{ width: "400px", height: "600px" }}
          />
        </div>
        <div className=" sm:w-1/2 w-full mx-auto p-4">
          <h1 className="sm:text-4xl text-2xl ">{productDetails.name}</h1>
          <div className="flex mt-2">
            <StarIcon className="text-yellow-500" />
            <StarIcon className="text-yellow-500" />
            <StarIcon className="text-yellow-500" />
            <StarIcon className="text-yellow-500" />
            <StarBorderOutlinedIcon className="text-yellow-500" />
            <p className=" text-base pt-0.5">26 reviews</p>
          </div>
          <p className="text-lg pt-4">INR {productDetails.price}</p>
          <p>(incl. of all taxes) </p>
          <p
            className="text-lg pt-4 font-light"
            style={{ letterSpacing: ".2rem" }}
          >
            DESCRIPTION
          </p>
          <p className="text-sm  font-mono ">
            {productDetails.description}
          </p>
          <button className="bg-black w-full text-white px-4  mt-2  rounded py-2">
            Add to Cart
          </button>

          <button className="bg-black w-full text-white px-4   rounded py-2 mt-4">
            Add to Wishlist
          </button>
        </div>
      </div>
    </div>
  );
}
