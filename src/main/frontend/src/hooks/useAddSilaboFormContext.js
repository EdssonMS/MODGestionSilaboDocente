import { useContext } from "react";
import AddSilaboFormContext from "../context/AddSilaboFormContext";
import React from 'react'

const useAddSilaboFormContext = () => {
  return useContext(AddSilaboFormContext)
}

export default useAddSilaboFormContext