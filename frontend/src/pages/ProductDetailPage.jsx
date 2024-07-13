import { useParams } from "react-router-dom";
import StarIcon from "@mui/icons-material/Star";
import StarBorderOutlinedIcon from "@mui/icons-material/StarBorderOutlined";
export default function ProductDetailPage() {
  const { id } = useParams();
//   console.log(id);
  return (
    <div className="sm:w-4/5 w-full mx-auto text-black ">
      {/* // display product details here half  side image and half side details */}
      <div className="flex flex-wrap justify-around gap-x-2 py-4">
        <div className="sm:w-2/5 w-full mx-auto flex justify-center">
          <img
            src="https://www.snitch.co.in/cdn/shop/files/05f3c942241254f0a1413ab383921106.webp?v=1718186797&width=1800"
            alt="product"
            style={{ width: "400px", height: "600px" }}
          />
        </div>
        <div className=" sm:w-1/2 w-full mx-auto p-4">
          <h1 className="sm:text-4xl text-2xl ">QUARTET GREEN STRIPE SHIRT</h1>
          <div className="flex mt-2">
            <StarIcon className="text-yellow-500" />
            <StarIcon className="text-yellow-500" />
            <StarIcon className="text-yellow-500" />
            <StarIcon className="text-yellow-500" />
            <StarBorderOutlinedIcon className="text-yellow-500" />
            <p className=" text-base pt-0.5">26 reviews</p>
          </div>
          <p className="text-lg pt-4">INR 999</p>
          <p>(incl. of all taxes) </p>
          <p
            className="text-lg pt-4 font-light"
            style={{ letterSpacing: ".2rem" }}
          >
            DESCRIPTION
          </p>
          <p className="text-sm  font-mono ">
            Give a majestic lift to your look with this dark green stripes
            pattern shirt. The shirt is crafted from fine 65%Ã¢Â viscose 35%
            polyester. It is a versatile staple and great for teaming with jeans
            for a more casual look or smartening up with a classic pair of
            chinos..
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
