import Card from "../components/Card";
import React from "react";
export default function HomePage() {
  const [products, setProducts] = React.useState([]);



  const fetchProducts = async () => {
    try {
      const response = await fetch("http://localhost:8080/api/product/getproduct");
      const data = await response.json();
      // console.log(data);
      setProducts(data);
    } catch (error) {
      console.log(error);
    }


  };

  React.useEffect(() => {
    fetchProducts();
  }, []);

  return (
    <div className="sm:w-4/5 w-full mx-auto text-white ">
      <div className="flex flex-wrap justify-around gap-y-4 py-4">
        {products.map((product) => (
          <Card key={product.id} product={product} />
        ))}
        

      </div>
    </div>
  );
}
