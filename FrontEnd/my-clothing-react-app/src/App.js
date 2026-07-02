import './App.css';
import HomePage from './components/pages/homepage/homepage.component';
import { Route, Routes } from 'react-router-dom';
import Shop from './components/shop/shop.component';
import { SignInAndSignUpPage } from './components/sign-in-and-sign-up/sign-in-and-sign-up.component';

export const HatsPage = () => {
  return <div>
            <h1>Hats details page</h1>
        </div>
}

function App() {
  return <div>
          <Routes>
            <Route path="/" element={<HomePage />} />
            <Route path='/shop' element={<Shop/>}/>
            <Route path='/signin' element ={<SignInAndSignUpPage/>}/>
          </Routes>
        </div>
}

export default App;
