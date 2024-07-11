import AddSilaboComponent from "./AddSilaboComponent";
import useAddSilaboFormContext from "../hooks/useAddSilaboFormContext";
import AddSilaboPage2 from "./AddSilaboPage2";
import AddSilaboPage3 from "./AddSilaboPage3";
import AddSilaboPage4 from "./AddSilaboPage4";
import AddSilaboPage5 from "./AddSilaboPage5";
import AddSilaboPage6 from "./AddSilaboPage6";

const AddSilaboFormInputs = () => {

    const {page} = useAddSilaboFormContext()

    const display = {
        0: <AddSilaboComponent />,
        1: <AddSilaboPage2 />,
        2: <AddSilaboPage3 />,
        3: <AddSilaboPage4 />,
        4: <AddSilaboPage5 />,
        5: <AddSilaboPage6 />
    }

    const content = (
        <div>
            {display[page]}
        </div>
    )

    return content
}

export default AddSilaboFormInputs