import React from 'react'
import {Box, Button, Card, Divider, Grid, Modal, TextField} from "@mui/material";
import {CartItem} from "./CartItem";
import {AddressCard} from "./AddressCard";
import AddLocationAltIcon from '@mui/icons-material/AddLocationAlt';
import {Field, Formik, ErrorMessage, Form} from "formik";
//import * as Yup from 'yup';

const items = [1,1,1,1]
const style = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 400,
    bgcolor: 'background.paper',
    outline:"none",
    boxShadow: 24,
    p: 4,
};
const initialValues={
    streetAddress:"",
    state:"",
    pincode:"",
    city:""
}
/*const validationSchema = Yup.object.shape({
    streetAddress:Yup.string().required("Please enter a street address"),
    state:Yup.string().required("Please enter a state"),
    pincode:Yup.string().required("Please enter a pincode"),
    city:Yup.string().required("Please enter a city")
})*/
export const Cart = () =>{
    const createOrderUsingSelectedAddress =() =>{

    }
    const [open,setOpen] = React.useState(false)
    const handleOpenAddressModal = () => setOpen(true)
    const handleCloseAddressModal = () => setOpen(false)
    const handleFormSubmit = (value) => {
        console.log("form value", value)
    }

    return (
        <>
            <main className="lg:flex justify-between">
                {/*Buy Resume*/}
                <section className="lg:w-[30%] space-y-6 lg:min-h-screen pt-10">
                    {items.map((item)=>(
                        <CartItem />
                    ))}
                    <Divider />
                    <div className="billDetails px-5 text-sm">
                        <p className="font-extralight py-5">Bill Details</p>
                        <div className="space-y-2">
                            <div className="flex justify-between text-gray-400">
                                <p>Item Total</p>
                                <p>$599</p>
                            </div>
                            <div className="flex justify-between text-gray-400">
                                <p>Deliver Fee</p>
                                <p>$21</p>
                            </div>
                            <div className="flex justify-between text-gray-400">
                                <p>Restaurant Charges</p>
                                <p>$33</p>
                            </div>
                            <Divider />
                        </div>
                        <div className="flex justify-between text-gray-400">
                            <p>Total Pay</p>
                            <p>$899</p>
                        </div>
                    </div>
                </section>
                <Divider orientation="vertical" flexItem/>
                {/*Delivery Addresses*/}
                <section className="lg:w-[70%] flex justify-center px-5 pb-10 lg:pb-3">
                    <div>
                        <h1 className="text-center font-semibold text-2xl py-10">Choose Delivery Address</h1>
                        <div className="flex gap-5 flex-wrap justify-center">
                            {[1,1,1,1].map((item)=>(
                                <AddressCard item={item} showButton={true} handleSelectAddress={createOrderUsingSelectedAddress} />
                            ))}
                            <Card className="flex gap-5 w-64 p-5">
                                <AddLocationAltIcon />
                                <div className="space-y-3 text-gray-500">
                                    <h1 className="font-semibold text-lg text-white">Add New Address</h1>
                                    <Button variant="outlined" fullWidth onClick={handleOpenAddressModal}>add</Button>
                                </div>
                            </Card>
                        </div>
                    </div>
                </section>
            </main>

            <Modal
                open = {open}
                onClose={handleCloseAddressModal}
                aria-labelledby="modal-modal-title"
                aria-describedby="modal-modal-description"
            >
                <Box sx={style}>
                    {/*Form*/}
                    <Formik
                        initialValues={initialValues}
                        //validationSchema={validationSchema}
                        onSubmit={handleFormSubmit}
                    >
                        <Form>
                            <Grid container spacing={2}>
                                {/*Fields*/}
                                <Grid item xs={12}>
                                    <Field
                                        as={TextField}
                                        name="streetAddress"
                                        label="Street Address"
                                        fullWidth
                                        variant="outlined"
                                        /*error={!ErrorMessage("streetAddress")}
                                        helperText={
                                            <ErrorMessage name="streetAddress">
                                                {(msg) =><span className="text-red-600">msg</span>}
                                            </ErrorMessage>
                                        }*/
                                    />
                                </Grid>
                                <Grid item xs={12}>
                                    <Field
                                        as={TextField}
                                        name="state"
                                        label="State"
                                        fullWidth
                                        variant="outlined"
                                        /*error={!ErrorMessage("streetAddress")}
                                        helperText={
                                            <ErrorMessage name="streetAddress">
                                                {(msg) =><span className="text-red-600">msg</span>}
                                            </ErrorMessage>
                                        }*/
                                    />
                                </Grid>
                                <Grid item xs={12}>
                                    <Field
                                        as={TextField}
                                        name="city"
                                        label="City"
                                        fullWidth
                                        variant="outlined"
                                        /*error={!ErrorMessage("streetAddress")}
                                        helperText={
                                            <ErrorMessage name="streetAddress">
                                                {(msg) =><span className="text-red-600">msg</span>}
                                            </ErrorMessage>
                                        }*/
                                    />
                                </Grid>
                                <Grid item xs={12}>
                                    <Field
                                        as={TextField}
                                        name="pincode"
                                        label="Pincode"
                                        fullWidth
                                        variant="outlined"
                                        /*error={!ErrorMessage("streetAddress")}
                                        helperText={
                                            <ErrorMessage name="streetAddress">
                                                {(msg) =><span className="text-red-600">msg</span>}
                                            </ErrorMessage>
                                        }*/
                                    />
                                </Grid>
                                {/*Actions*/}
                                <Grid item xs={12}>
                                    <Button fullWidth variant="contained" type="submit" color="primary" className="">
                                        Deliver Here
                                    </Button>
                                </Grid>
                            </Grid>
                        </Form>
                    </Formik>
                </Box>
            </Modal>
        </>
    )
}
