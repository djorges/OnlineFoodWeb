const {createTheme} = require("@mui/material");

export const darkTheme = createTheme({
    palette: {
        mode:"dark",
        primary:{
            main:"#0032ee" //#0032ee
        },
        secondary:{
            main: "#242B2E"
        },
        black:{
          main: "#0D0D0D"
        },
        background:{
            main: "#00000000",
            default: "#0D0D0D",
            paper:"#0D0D0D"
        },
        textColor:{
            main: "#111111"
        }
    }
})