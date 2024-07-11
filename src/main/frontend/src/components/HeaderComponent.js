import React from 'react'

export const HeaderComponent = () => {
  return (
    <div className='header'>
        <header>
            <nav className='navbar navbar-expand-md navbar-dark justify-content-center' style={{ backgroundColor: '#044d76' }}>
                <div>
                    <a href='/' className='navbar-brand'>Sistema de ayuda al docente - Módulo de sílabos</a>
                </div>
            </nav>
        </header>
    </div>
  )
}

export default HeaderComponent;