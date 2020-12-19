
import './App.css';
import Dashboard from './pages/DashboardNew';
import Error from  './pages/Error'
import { BrowserRouter as Router,Switch,Route } from 'react-router-dom';
import tempR from './components/tempR';
import Login from './components/Login';

import { AuthProvider } from "./contexts/AuthContext"
import checkD from "./components/checkD"
import PrivateRoute from "./components/PrivateRoute"
import ForgotPassword from "./components/ForgotPassword"
import UpdateProfile from "./components/UpdateProfile"
import Signup from "./components/Signup"

function App() {

  return (
    <>
    <div className="App">
      
      <Router>
        <AuthProvider>
      <Switch>
        <PrivateRoute exact path="/" component={checkD}/>
        <PrivateRoute exact path="/admin-home" component={Dashboard}/>
        <PrivateRoute path="/update-profile" component={UpdateProfile} />
        <Route exact path="/test" component={tempR}/>
        <Route exact path="/login" component={Login}/>
        <Route exact path="/signup" component={Signup} />
        <Route exact path="/forgot-password" component={ForgotPassword} />
        <Route component ={Error}/>
      </Switch>
      </AuthProvider>
      </Router>
    {/*<LineChart/>
    <BarChart/>
    <DoughnutChart/>*/}
    </div>
    </>
  );
}

export default App;