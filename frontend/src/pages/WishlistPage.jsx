import React from "react";
import axios from "axios";
import Card from "../components/Card";
import Loadar from "../components/Loadar";

export default function WishlistPage() {
  const [wishlist, setWishlist] = React.useState([]);
  const [loading, setLoading] = React.useState(false);

  const fetchWishlist = async () => {
    if (localStorage.getItem("user") === null) {
      alert("Please login to view wishlist");
      return;
    }
    try {
      setLoading(true);
      const user = JSON.parse(localStorage.getItem("user"));
      const response = await axios.get(
        `http://localhost:8080/api/wishlist/getwishlist/${user.id}`
      );
      //   console.log(response.data);
      setWishlist(response.data);
    } catch (error) {
      console.log(error);
    } finally {
      setLoading(false);
    }
  };

  React.useEffect(() => {
    fetchWishlist();
  }, []);

  return (
    <div className="sm:w-4/5 w-full mx-auto text-white ">
      {loading ? (
        <Loadar />
      ) : (
        <div className="flex flex-wrap justify-around sm:justify-start gap-y-4 py-4">
          {wishlist.map((product) => (
            <Card key={product.id} product={product.product} />
          ))}
        </div>
      )}

      {
        wishlist.length === 0 && !loading && (
          <div className="text-center font-bold text-black text-2xl py-4">
            No products in wishlist
          </div>
        )
      }

    </div>
  );
}
