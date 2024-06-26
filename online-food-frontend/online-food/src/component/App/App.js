import {Navbar} from "../Navbar/Navbar";
import {CssBaseline, ThemeProvider} from "@mui/material";
import {darkTheme} from "../../theme/DarkTheme";
import Home from "../Home/Home";
import RestaurantDetails from "../Restaurant/RestaurantDetails";
import {Cart} from "../Cart/Cart";
import Profile from "../Profile/Profile";

function App() {
  return (
    <div className="App">
        <ThemeProvider theme={darkTheme}>
            <CssBaseline />
            <Navbar />
            {/*<Home />*/}
            {/*<RestaurantDetails />*/}
            {/*<Cart/>*/}
            <Profile />
        </ThemeProvider>
    </div>
  );
}

export default App;
