import React from 'react'
import {SidebarData} from "./SidebarData"

export const Sidebar = () => {
  return (
    <div className='sidebar'>
      <ul className='sidebar-list'>
      {SidebarData.map((val, key)=> {
        return (
          <li key={key} className='sidebar-row' onClick={()=> {window.location.pathname = val.link}}>
            <div id='title'>
              {val.title}
            </div>
          </li>
        )
      })}
      </ul>
    </div>
  )
}

export default Sidebar;
