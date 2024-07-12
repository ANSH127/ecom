import Card from "../components/Card";
export default function HomePage() {
  return (
    <div className="sm:w-4/5 w-full mx-auto text-white ">
      <div className="flex flex-wrap justify-around gap-y-4 py-4">
        <Card />
        <Card />
        <Card />
        <Card />
        <Card />
        <Card />
        <Card />
        <Card />

      </div>
    </div>
  );
}
