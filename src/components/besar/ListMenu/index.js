import React from 'react'
import { StyleSheet, Text, View } from 'react-native'
import { CardMenu } from '../..'

const ListMenu = ({menus, navigation}) => {
    return (
        <View>
            {menus.map((menu) => {
                return <CardMenu menu={menu} key={menu.id} navigation={navigation}/>
            })}
        </View>
    )
}

export default ListMenu

const styles = StyleSheet.create({})
