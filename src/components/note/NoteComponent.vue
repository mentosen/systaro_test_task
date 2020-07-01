<template>
    <div class="note note_padding">
        <div class="note__header-block">
            <span class="note__date">{{noteTime}}</span>
            <dropdown icon="ellipsis-vertical">
                <dropdown-item
                        name="update"
                        icon="pencil-outline"
                        color-class="pencil-outline_yellow"
                        @action="update"
                />
                <dropdown-item
                        name="delete"
                        icon="close-outline"
                        color-class="close-outline_red"
                        @action="deleteNote"
                />
            </dropdown>
        </div>
        <span class="primary-text-color note__message">{{note.message}}</span>
    </div>
</template>

<script>
    import moment from 'moment';
    import Dropdown from "@/components/common/Dropdown";
    import DropdownItem from "@/components/common/DropDownItem";

    import {update, deleteNote} from "@/api/noteApi";

    export default {
        name: "NoteComponent",
        components: {Dropdown, DropdownItem},
        props:{
            note: {
                type: Object,
                required: true
            }
        },
        computed: {
            noteTime() {
                return moment(this.note.create_date).format('HH:mm');
            },
        },
        methods: {
            update(){

            },
            deleteNote(){
                let that = this;
                deleteNote(that.note.id).then(response => {
                    that.$emit('get-notes')
                })
            }
        }
    }
</script>

<style scoped>

</style>