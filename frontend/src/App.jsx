import "./App.css";

import {
  BrowserRouter as Router,
  Routes,
  Route
  // Link
} from 'react-router-dom';




import HomePage from './pages/HomePage';
import Header from "./components/Header";
import ProductDetailPage from "./pages/ProductDetailPage";
function App() {
  return (
    <Router>
      <Header />
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/product/:id" element={<ProductDetailPage />} />
      </Routes>
    </Router>
  );
}

export default App;
