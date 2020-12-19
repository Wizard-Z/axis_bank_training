import React from 'react'

export default function hero({children,hero}) {
    return (
        <header className={hero}>{children}</header>
    )
}
hero.defaultProps={
    hero:'defaultHero'
}
